package com.temilol.shoestore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.temilol.shoestore.R
import com.temilol.shoestore.databinding.FragmentNewShoeBinding

class NewShoeFragment : Fragment(R.layout.fragment_new_shoe) {
    private lateinit var binding: FragmentNewShoeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewShoeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}