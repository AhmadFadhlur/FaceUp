package com.example.faceup.ui.detail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.faceup.databinding.FragmentDetailBinding
import com.example.faceup.databinding.ListProductBinding

class ProductAdapter(private val listproduct : ArrayList<String>)  :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

        inner class ViewHolder(private val binding: ListProductBinding) :
            RecyclerView.ViewHolder(binding.root){

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}