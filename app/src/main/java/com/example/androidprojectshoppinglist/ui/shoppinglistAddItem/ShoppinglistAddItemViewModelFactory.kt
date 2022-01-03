package com.example.androidprojectshoppinglist.ui.shoppinglistAddItem

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppinglistDatabaseDao


class ShoppinglistAddItemViewModelFactory(val dataSource: ShoppinglistDatabaseDao, private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ShoppinglistAddItemViewModel::class.java)){
            return ShoppinglistAddItemViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}