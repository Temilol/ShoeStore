package com.temilol.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.temilol.shoestore.model.Shoe

class ShoeViewModel : ViewModel() {
    private lateinit var shoeLists: MutableList<Shoe>

    private val _shoes by lazy { MutableLiveData(shoeLists) }
    val shoes: LiveData<MutableList<Shoe>> get() = _shoes

    init {
        loadShoes()
    }

    private fun loadShoes() {
        shoeLists = mutableListOf(
            Shoe(
                name = "Air Force",
                size = 7.0,
                company = "Nike",
                description = "Best worn with suit in town"
            ),
            Shoe(
                name = "Canvas",
                size = 8.5,
                company = "Nike",
                description = "Best Shoe in town"
            )
        )
    }

    fun addShoe(newShoe: Shoe) {
        val oldShoeCollection = _shoes.value ?: mutableListOf()
        oldShoeCollection.add(newShoe)
        _shoes.value = oldShoeCollection
    }
}