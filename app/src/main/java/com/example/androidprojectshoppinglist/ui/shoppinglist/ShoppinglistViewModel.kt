package com.example.androidprojectshoppinglist.ui.shoppinglist

import android.app.Application
import androidx.lifecycle.*
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppinglistDatabaseDao

class ShoppinglistViewModel(val database: ShoppinglistDatabaseDao, application: Application) : AndroidViewModel(application) {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Shoppinglist Fragment"
    }
    val text: LiveData<String> = _text
}

/*
class ShoppinglistViewModelFactory(private val repository: ShoppinglistRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoppinglistViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ShoppinglistViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
 */
