package com.example.androidprojectshoppinglist.ui.shoppinglist

import android.widget.CheckBox
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppingItem

@BindingAdapter("shoppingitemNameString")
fun CheckBox.setItemNameString(item: ShoppingItem?){
    item?.let {
        text = item.name
    }
}

@BindingAdapter("shoppingItemCheckedBoolean")
fun  CheckBox.setCheckboxValue(item: ShoppingItem?){
    item?.let {
        isChecked = item.checked
    }
}

@BindingAdapter("shoppingItemQuantityString")
fun  TextView.setItemQuantityString(item: ShoppingItem?){
    item?.let {
        text = item.quantity.toString()
    }
}


