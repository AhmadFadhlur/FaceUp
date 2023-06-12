package com.example.faceup.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.findNavController
import com.example.faceup.R

import com.example.faceup.databinding.FragmentLoginBinding
import com.example.faceup.utils.StoreManager
import com.example.faceup.utils.ViewModelFactory
import com.example.faceup.utils.dataStore
import com.example.faceup.utils.wrapper.Resource
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch
import java.util.regex.Pattern


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var storeManager: StoreManager
    private val loginViewModel : LoginViewModel by viewModels {
        ViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emailFocusListener()
        passwordValidation()
        playAnimation()
        toregister()
        observeData()
    }

    private fun playAnimation (){
        ObjectAnimator.ofFloat(binding.imgLogin, View.TRANSLATION_X , -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val login = ObjectAnimator.ofFloat(binding.tvLogin, View.ALPHA, 1f).setDuration(250)
        val loginDescription = ObjectAnimator.ofFloat(binding.tvLoginDescription, View.ALPHA, 1f).setDuration(250)
        val emailText  = ObjectAnimator.ofFloat(binding.tvEmail, View.ALPHA, 1f).setDuration(250)
        val emailEd = ObjectAnimator.ofFloat(binding.textInputLayoutEmail, View.ALPHA, 1f).setDuration(250)
        val passText = ObjectAnimator.ofFloat(binding.tvPassword, View.ALPHA, 1f).setDuration(250)
        val passEd = ObjectAnimator.ofFloat(binding.textInputLayoutPassword, View.ALPHA, 1f).setDuration(250)
        val btnLogin = ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 1f).setDuration(250)
        val dontHvAkunText = ObjectAnimator.ofFloat(binding.tvDontHa, View.ALPHA, 1f).setDuration(250)
        val regisText = ObjectAnimator.ofFloat(binding.tvRegister, View.ALPHA, 1f).setDuration(250)

        AnimatorSet().apply {
            playSequentially(login,loginDescription, emailText, emailEd, passText,passEd, btnLogin, dontHvAkunText, regisText)
            start()
        }
        setBottomNav()
    }
    private fun passwordValidation(){
        binding.tiPassword.doOnTextChanged { text, start, before, count ->
            if(text!!.length < 8){
                binding.textInputLayoutPassword.error = "Passoword must be more 8 Characters"
            } else if(text.length >= 8) {
                binding.textInputLayoutPassword.error = null
                binding.textInputLayoutPassword.helperText = null
            }
        }
    }

    private fun emailFocusListener(){
        binding.tiEmail.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus){
                binding.textInputLayoutEmail.helperText =validemail()
            }
        }
    }

    private fun validemail() : String?{
        val emailText = binding.tiEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return  "Invalid Email Address"
        }
        return null
    }

    private fun toregister(){
        binding.tvRegister.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun observeData (){
        binding.apply {
            val email = tvEmail.text.toString()
            val password = tvPassword.text.toString()
            val dataStore : DataStore<Preferences> = requireContext().dataStore
            storeManager = StoreManager.getInstance(dataStore)
            btnLogin.setOnClickListener {btn ->
                loginViewModel.Postlogin(email,password)
                loginViewModel.login.observe(viewLifecycleOwner){
                    if (it != null){
                        when(it){
                            is Resource.Error ->{
                                Toast.makeText(requireContext(), "Gagal Register", Toast.LENGTH_LONG).show()
                            }
                            is Resource.Success -> {
                                it?.data?.token?.let {tokenLogin ->
                                    lifecycleScope.launch{
                                        storeManager.saveToken(tokenLogin)
                                    }
                                }
                                Toast.makeText(requireContext(), "Succsess Login", Toast.LENGTH_LONG).show()
                                btn.findNavController().navigate(R.id.action_loginFragment_to_homePage)

                            }
                            is Resource.Loading -> {

                            }
                        }
                    }

                }
            }
        }
    }

    private fun setBottomNav(){
        val navBar = activity?.findViewById<BottomNavigationView>(R.id.nav_view)
        navBar?.visibility = View.GONE
    }
}