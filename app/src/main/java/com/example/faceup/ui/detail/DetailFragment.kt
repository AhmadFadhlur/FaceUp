package com.example.faceup.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.faceup.R
import com.example.faceup.databinding.FragmentDetailBinding
import com.example.faceup.ui.bottomsheet.adapter.ProductAdapter
import com.example.faceup.utils.Product
import com.example.faceup.utils.ViewModelFactory
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    lateinit var dialogBottomSheet : BottomSheetDialog

    private lateinit  var rvProduct : RecyclerView
    private val detailViewModel : DetailViewModel by viewModels {
        ViewModelFactory(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBottomNav()
        showBottomSheet()




    }

    private fun observeDataDetail(){

    }

    private fun showBottomSheet(){
        binding.extendedFabBuyRecomenProdcut.setOnClickListener {
            findNavController().navigate(R.id.bottomSheetProductFragment)
        }
    }

    private fun setBottomNav(){
        val botAppbar = activity?.findViewById<BottomAppBar>(R.id.bottomAppBar)
        botAppbar?.visibility = View.GONE
        val floatButton = activity?.findViewById<FloatingActionButton>(R.id.fab_buttonCamera)
        floatButton?.visibility = View.GONE
    }




}