package com.temilol.shoestore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.temilol.shoestore.R
import com.temilol.shoestore.model.Shoe

class ShoeAdapter(private val shoeList: MutableList<Shoe>) :
    RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    class ShoeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameText: TextView = view.findViewById(R.id.shoe_name_item)
        val sizeText: TextView = view.findViewById(R.id.shoe_size_item)
        val companyText: TextView = view.findViewById(R.id.shoe_company_item)
        val descriptionText: TextView = view.findViewById(R.id.shoe_description_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shoe_row_item, parent, false)
        return ShoeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val item = shoeList[position]
        holder.nameText.text = item.name
        holder.sizeText.text = "Size: ${item.size.toString()}"
        holder.companyText.text = item.company
        holder.descriptionText.text = item.description
    }

    override fun getItemCount(): Int = shoeList.size

}