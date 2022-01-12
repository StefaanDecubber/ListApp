package com.example.androidprojectshoppinglist.ui.shoppinglistAddItem

import android.app.Application
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import androidx.navigation.Navigation
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppingItem
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppinglistDatabaseDao
import com.example.androidprojectshoppinglist.extentionmethods.orFalse
import com.example.androidprojectshoppinglist.model.FormValidationErrorModel
import com.example.androidprojectshoppinglist.model.FormValidationErrorTags
import kotlinx.coroutines.*

//For form validation and get values from edittext
//https://github.com/furkanaskin/DataBindingExample/tree/master/app/src/main

class ShoppinglistAddItemViewModel(val database: ShoppinglistDatabaseDao, application: Application) : AndroidViewModel(application){
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)



    fun createItem(name: String, category: String, quantity: String){
        uiScope.launch {
                insert(ShoppingItem(name, category, quantity, false))
            }
        }

    private suspend fun insert(shippingItem: ShoppingItem) {
        withContext(Dispatchers.IO) {
            database.insert(shippingItem)
        }
    }

}





