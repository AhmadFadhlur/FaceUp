package com.example.faceup.ui.homepage

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faceup.R
import com.example.faceup.databinding.FragmentHomePageBinding
import com.example.faceup.ui.profile.ProfileFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomePage : Fragment() {

    private var _binding : FragmentHomePageBinding? = null
    private val binding get() = _binding!!
    private val navArgs : HomePageArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nama = navArgs.name.toString()
        binding.tvName.text = nama
        setBottomNav()
        moveToDetail ()

    }

    private fun customDialog(){
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.custom_dialog)

        val btnOk = dialog.findViewById<Button>(R.id.buttonOke)
        btnOk.setOnClickListener{
            dialog.dismiss()
            findNavController().navigate(R.id.bottomSheetChoosePictureFragment)
        }
        dialog.show()
    }

    private fun moveToDetail (){
        binding.buttonFloatCam.setOnClickListener {
            customDialog()
        }
    }


    private fun setBottomNav(){
        val botAppbar = activity?.findViewById<BottomAppBar>(R.id.nav_view)
        botAppbar?.visibility = View.VISIBLE
    }

}