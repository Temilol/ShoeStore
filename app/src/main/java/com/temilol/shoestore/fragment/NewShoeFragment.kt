package com.temilol.shoestore.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.temilol.shoestore.R
import com.temilol.shoestore.databinding.FragmentNewShoeBinding
import com.temilol.shoestore.model.Shoe
import com.temilol.shoestore.viewmodel.ShoeViewModel

class NewShoeFragment : Fragment(R.layout.fragment_new_shoe) {
    private lateinit var binding: FragmentNewShoeBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewShoeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            saveButton.setOnClickListener {
                val newShoe = when (sizeEdittext.text.toString().isEmpty()) {
                    true -> null
                    else -> Shoe(
                        name = shoeNameEdittext.text.toString(),
                        size = sizeEdittext.text.toString().toDouble(),
                        company = companyEdittext.text.toString(),
                        description = descriptionEdittext.text.toString()
                    )
                }
                if (newShoe != null) {
                    shoeViewModel.addShoe(newShoe)
                    navigate()
                    Toast.makeText(
                        context,
                        "${shoeNameEdittext.text} is added to your collection",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "Please enter a valid size",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            cancelButton.setOnClickListener {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Cancel")
                    .setMessage("Are you sure you want to cancel?")
                    .setPositiveButton("Yes") { _, _ ->
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