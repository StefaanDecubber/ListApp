package com.example.androidprojectshoppinglist.ui.shoppinglist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppinglistDatabaseDao


class ShoppinglistViewModelFactory(val dataSource: ShoppinglistDatabaseDao, private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ShoppinglistViewModel::class.java)){
            return ShoppinglistViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}