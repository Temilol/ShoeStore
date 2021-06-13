package com.temilol.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.temilol.shoestore.model.Shoe

class ShoeViewModel : ViewModel() {
    private lateinit var shoeLists: MutableList<Shoe>

    private val _shoes by lazy { MutableLiveData(shoeLists) }
    val shoes: LiveData<MutableList<Shoe>> get() = _shoes

    private val _addedSuccessfully by lazy { MutableLiveData(false) }
    val addedSuccessfully: LiveData<Boolean> get() = _addedSuccessfully

    private val _sizeHasError by lazy { MutableLiveData(false) }
    val sizeHasError: LiveData<Boolean> get() = _sizeHasError

    var name: String = ""
    var size: String = ""
    var company: String = ""
    var description: String = ""

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

    private fun addShoe(newShoe: Shoe) {
        val oldShoeCollection = _shoes.value ?: mutableListOf()
        oldShoeCollection.add(newShoe)
        _shoes.value = oldShoeCollection
    }

    fun addToCollection() {
        if (size.isNotBlank()) {
            val newShoe = Shoe(name, size.toDouble(), company, description)
            addShoe(newShoe)
            _addedSuccessfully.value = true
            _sizeHasError.value = false
        } else {
            _addedSuccessfully.value = false
            _sizeHasError.value = true
        }
    }

    fun resetFields() {
        name = ""
        size = ""
        company = ""
        description = ""
        _addedSuccessfully.value = false
    }

    fun resetErrorState() {
        _sizeHasError.value = false
    }
}