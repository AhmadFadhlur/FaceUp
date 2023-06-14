package com.example.faceup.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.faceup.R
import com.example.faceup.databinding.FragmentDetailBinding
import com.example.faceup.databinding.FragmentRegisterBinding
import com.example.faceup.utils.ViewModelFactory
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    lateinit var dialogBottomSheet : BottomSheetDialog
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
        binding.extendedFabBuyRecomenProdcut.setOnClickListener {
            showBottomSheet()
        }
    }
    private fun observeDataDetail(){

    }

    private fun showBottomSheet(){
        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet,null)
        dialogBottomSheet = BottomSheetDialog(requireContext(),R.style.BottomSheetDialogTheme)
        dialogBottomSheet.setContentView(bottomSheetView)
        dialogBottomSheet.show()
    }

    private fun setBottomNav(){
        val botAppbar = activity?.findViewById<BottomAppBar>(R.id.bottomAppBar)
        botAppbar?.visibility = View.GONE
        val floatButton = activity?.findViewById<FloatingActionButton>(R.id.buttonCamera)
        floatButton?.visibility = View.GONE
    }

}