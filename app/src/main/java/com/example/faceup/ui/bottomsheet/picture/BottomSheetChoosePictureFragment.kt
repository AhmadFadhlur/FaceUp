package com.example.faceup.ui.bottomsheet.picture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.faceup.R
import com.example.faceup.databinding.FragmentBottomSheetChoosePictureBinding
import com.example.faceup.databinding.FragmentHomePageBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetChoosePictureFragment : BottomSheetDialogFragment() {

    private var _binding : FragmentBottomSheetChoosePictureBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomSheetChoosePictureBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFlagToDetail()
    }


    private fun setFlagToDetail(){
        binding.apply {
            tvCamera.setOnClickListener {
                val action = BottomSheetChoosePictureFragmentDirections.actionBottomSheetChoosePictureFragmentToDetailFragment2(1)
                findNavController().navigate(action)

            }
            tvGallery.setOnClickListener {
                val action = BottomSheetChoosePictureFragmentDirections.actionBottomSheetChoosePictureFragmentToDetailFragment2(2)
                findNavController().navigate(action)
            }
        }
    }
}