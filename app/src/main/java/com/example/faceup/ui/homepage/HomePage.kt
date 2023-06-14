package com.example.faceup.ui.homepage

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.faceup.R
import com.example.faceup.databinding.FragmentHomePageBinding
import com.example.faceup.ui.profile.ProfileFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
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
        moveToDetail()
    }

    private fun moveToDetail (){
        binding.buttonFloatCam.setOnClickListener {
            findNavController().navigate(R.id.detailFragment2)
        }
    }

    private fun setBottomNav(){
        val botAppbar = activity?.findViewById<BottomAppBar>(R.id.bottomAppBar)
        botAppbar?.visibility = View.VISIBLE
        val floatButton = activity?.findViewById<FloatingActionButton>(R.id.buttonCamera)
        floatButton?.visibility = View.VISIBLE
    }

}