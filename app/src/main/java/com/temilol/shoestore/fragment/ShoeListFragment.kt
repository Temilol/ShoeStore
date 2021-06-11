package com.temilol.shoestore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.temilol.shoestore.R
import com.temilol.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment(R.layout.fragment_shoe_list) {
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}