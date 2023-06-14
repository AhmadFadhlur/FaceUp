package com.example.faceup.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.faceup.R
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBottomNav()
    }

    private fun setBottomNav(){
        val botAppbar = activity?.findViewById<BottomAppBar>(R.id.bottomAppBar)
        botAppbar?.visibility = View.VISIBLE
        val floatButton = activity?.findViewById<FloatingActionButton>(R.id.buttonCamera)
        floatButton?.visibility = View.VISIBLE
    }
}