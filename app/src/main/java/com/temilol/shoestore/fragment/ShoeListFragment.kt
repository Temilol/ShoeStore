package com.temilol.shoestore.fragment

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.temilol.shoestore.R
import com.temilol.shoestore.databinding.FragmentShoeListBinding
import com.temilol.shoestore.viewmodel.ShoeViewModel

class ShoeListFragment : Fragment(R.layout.fragment_shoe_list) {
    private val shoeViewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.lifecycleOwner = this

        shoeViewModel.shoes.observe(viewLifecycleOwner, { newShoeList ->
            newShoeList.forEach { newShoe ->
                val linearLayout: LinearLayout = binding.shoeListLinearlayout
                val shoeRowItemCardView = ShoeRowItemCardView(requireContext())
                shoeRowItemCardView.updateShoeView(newShoe)
                linearLayout.addView(shoeRowItemCardView)
            }
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            floatingActionButton.setOnClickListener {
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToNewShoeFragment())
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) ||
                super.onOptionsItemSelected(item)
    }
}