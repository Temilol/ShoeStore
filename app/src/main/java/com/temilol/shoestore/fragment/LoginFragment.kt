package com.temilol.shoestore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.temilol.shoestore.R
import com.temilol.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loginButton.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
            signupButton.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
    }

}