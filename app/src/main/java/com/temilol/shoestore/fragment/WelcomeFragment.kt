package com.temilol.shoestore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.temilol.shoestore.R
import com.temilol.shoestore.databinding.FragmentWelcomeBinding
import com.temilol.shoestore.model.Shoe
import com.temilol.shoestore.viewmodel.ShoeViewModel

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding = FragmentWelcomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            continueButton.setOnClickListener {
                shoeViewModel.addShoe(
                    Shoe(
                        name = "ddhss",
                        size = 3.0,
                        company = "aSHsyy",
                        description = "Hsbeuwouowe"
                    )
                )

                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
            }
        }
    }
}