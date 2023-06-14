package com.example.faceup.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.faceup.R
import com.example.faceup.databinding.FragmentRegisterBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class DetailFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    lateinit var dialogBottomSheet : BottomSheetDialog


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBottomSheet()

    }
    private fun showBottomSheet(){
        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet,null)
        dialogBottomSheet = BottomSheetDialog(requireContext(),R.style.BottomSheetDialogTheme)
        dialogBottomSheet.setContentView(bottomSheetView)
    }
}