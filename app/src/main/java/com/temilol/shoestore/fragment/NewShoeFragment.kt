package com.temilol.shoestore.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.temilol.shoestore.R
import com.temilol.shoestore.databinding.FragmentNewShoeBinding
import com.temilol.shoestore.viewmodel.ShoeViewModel

class NewShoeFragment : Fragment(R.layout.fragment_new_shoe) {
    private lateinit var binding: FragmentNewShoeBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_shoe, container, false)
        binding.shoeViewModel = shoeViewModel
        binding.lifecycleOwner = this

        // This observe if the shoe detail was added successfully
        // It navigates to the list page, display a toast message and resets the fields if added successfully
        shoeViewModel.addedSuccessfully.observe(viewLifecycleOwner, Observer { isAdded ->
            if (isAdded) {
                navigate()
                Toast.makeText(
                    context,
                    "${shoeViewModel.name} is added to your collection",
                    Toast.LENGTH_SHORT
                ).show()
                shoeViewModel.resetFields()
            }
        })


        // This observe if the shoe size and throw an a toast message if it is not entered
        shoeViewModel.sizeHasError.observe(viewLifecycleOwner, Observer { hasError ->
            if (hasError) {
                Toast.makeText(
                    context,
                    "Please enter a valid size",
                    Toast.LENGTH_SHORT
                ).show()
                shoeViewModel.resetErrorState()
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            // This sets up a listener for the cancel button
            // Display a confirmation dialog for the user and responds based on the user's decision
            cancelButton.setOnClickListener {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Cancel")
                    .setMessage("Are you sure you want to cancel?")
                    .setPositiveButton("Yes") { _, _ ->
                        shoeViewModel?.resetFields()
                        navigate()
                    }
                    .setNegativeButton("No", null)
                    .show()
            }
        }
    }

    private fun navigate() {
        findNavController().navigate(NewShoeFragmentDirections.actionNewShoeFragmentToShoeListFragment())
    }

}