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


    private val formViewStateLiveData: MutableLiveData<AddItemFormViewState> = MutableLiveData()

    fun getFormViewStateLiveData(): LiveData<AddItemFormViewState> =
        formViewStateLiveData

    private fun setFormViewStateLiveData(viewState: AddItemFormViewState) {
        formViewStateLiveData.value = viewState
    }

    fun initData() {
        setFormViewStateLiveData(AddItemFormViewState())
    }

    private fun setFormError(error: FormValidationErrorModel) {
        formViewStateLiveData.value?.let { viewState ->
            val errors = viewState.formErrors.toMutableList().apply {
                if (this.contains(error).not()) {
                    add(error)
                }
            }
            setFormViewStateLiveData(viewState.copy(formErrors = errors))
        }
    }

    fun clearFormErrors(
        tag: FormValidationErrorTags
    ) {
        formViewStateLiveData.value?.let { viewState ->
            val current = viewState.formErrors
            val newList = current.toMutableList()
            if (newList.map { it.tags }.contains(tag)) {
                val index = newList.map { it.tags }.indexOf(tag)
                newList.removeAt(index)
            }
            setFormViewStateLiveData(viewState.copy(formErrors = newList))
        }
    }

    fun createItem(){
        viewModelScope.launch {
            val formValues = formViewStateLiveData.value
            val shoppingItem =
                formValues?.let { ShoppingItem(it.name, formValues.category, formValues.quantity, false) }
            if (shoppingItem != null) {
                insert(shoppingItem)
            }
        }
    }

    fun submitForm(): Boolean {
        val formValues = formViewStateLiveData.value
        validateForm()
        return true
    }

    private fun validateForm() {
        val formValues = formViewStateLiveData.value
        when {
            formValues?.name?.contains(Regex("[^A-Za-z]")).orFalse() -> setFormError(
                FormValidationErrorModel(
                    FormValidationErrorTags.INVALID_NAME,
                    "Invalid name"
                )
            )
            formValues?.category?.contains(Regex("[^A-Za-z]")).orFalse() -> setFormError(
                FormValidationErrorModel(
                    FormValidationErrorTags.INVALID_CATEGORY,
                    "Invalid category"
                )
            )
            formValues?.quantity?.toIntOrNull() ?: 0 <= 0 -> setFormError(
                FormValidationErrorModel(
                    FormValidationErrorTags.INVALID_QUANTITY,
                    "Invalid quantity"
                )
            )
        }

    }

    private suspend fun insert(shippingItem: ShoppingItem) {
        withContext(Dispatchers.IO) {
            database.insert(shippingItem)
        }
    }



}

