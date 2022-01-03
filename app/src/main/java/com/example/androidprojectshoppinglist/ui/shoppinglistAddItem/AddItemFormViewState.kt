package com.example.androidprojectshoppinglist.ui.shoppinglistAddItem

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.androidprojectshoppinglist.model.FormValidationErrorModel

@Suppress("ConstructorParameterNaming")
data class AddItemFormViewState(
    private var _name: String = "",
    private var _category: String = "",
    private var _quantity: String = "",
    var formErrors: MutableList<FormValidationErrorModel> = mutableListOf()
): BaseObservable(){
    var name: String
        @Bindable get() = _name
        set(value) {
            _name = value
            notifyPropertyChanged(BR.name)
        }
    var category: String
        @Bindable get() = _category
        set(value) {
            _category = value
            notifyPropertyChanged(BR.category)
        }
    var quantity: String
        @Bindable get() = _quantity
        set(value) {
            _quantity = value
            notifyPropertyChanged(BR.quantity)
        }

    @Bindable
    fun isAddButtonEnabled(): Boolean {
        notifyPropertyChanged(BR.continueButtonEnabled)
        return name.isEmpty().not() &&
                category.isEmpty().not() &&
                quantity.isEmpty().not() &&
                formErrors.isEmpty()
    }
}
