package com.temilol.shoestore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.temilol.shoestore.R
import com.temilol.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment(R.layout.fragment_instruction) {
    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstructionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            enterStoreButton.setOnClickListener {
                findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
            }
        }
    }
}