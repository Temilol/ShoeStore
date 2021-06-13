package com.temilol.shoestore.fragment

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import com.temilol.shoestore.R
import com.temilol.shoestore.model.Shoe

class ShoeRowItemCardView(context: Context) : MaterialCardView(context) {
    private var shoeNameItem: TextView
    private var shoeCompanyItem: TextView
    private var shoeSizeItem: TextView
    private var shoeDescriptionItem: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.shoe_row_item, this)
        shoeNameItem = findViewById(R.id.shoe_name_item)
        shoeSizeItem = findViewById(R.id.shoe_size_item)
        shoeDescriptionItem = findViewById(R.id.shoe_description_item)
        shoeCompanyItem = findViewById(R.id.shoe_company_item)
    }

    fun updateShoeView(shoe: Shoe) {
        shoeNameItem.text = shoe.name
        shoeDescriptionItem.text = shoe.description
        shoeCompanyItem.text = shoe.company
        shoeSizeItem.text = "Size ${shoe.size}"
    }
}