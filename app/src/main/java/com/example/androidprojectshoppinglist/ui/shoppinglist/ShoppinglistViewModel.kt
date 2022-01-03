package com.example.androidprojectshoppinglist.ui.shoppinglist

import android.app.Application
import androidx.lifecycle.*
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppingItem
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppinglistDatabaseDao
import kotlinx.coroutines.*

class ShoppinglistViewModel(val database: ShoppinglistDatabaseDao, application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val shoppinglist = database.getAllItems()
    val addButtonVisible = Transformations.map(shoppinglist){
        it?.isEmpty()
    }
    val clearButtonVisible = Transformations.map(shoppinglist) {
        it?.isNotEmpty()
    }

    fun onCreateData(){
        viewModelScope.launch {
            var shoppingItem = ShoppingItem("Eggs", "Dairy", "12")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Cheese", "Dairy","1")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Sausages", "Meat","2")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Chicken", "Meat","1")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Banana", "Fruit","1")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Orange", "Fruit","5")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Fishsticks", "Meat","3")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Paper towels", "Cleaning","2")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Shampoo", "Care","2")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Corn flakes", "Cereals","1")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Beer", "Drinks","24")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Beer", "Drinks","1")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Beer", "Drinks","1")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Beer", "Drinks","1")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Beer", "Drinks","1")
            insert(shoppingItem)
            shoppingItem = ShoppingItem("Beer", "Drinks","1")
            insert(shoppingItem)

        }
    }
    fun clearAllItems(){
        viewModelScope.launch {
            clear()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.deleteAllItems()
        }
    }

    private suspend fun insert(shippingItem: ShoppingItem) {
        withContext(Dispatchers.IO) {
            database.insert(shippingItem)
        }
    }
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
