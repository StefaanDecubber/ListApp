package com.example.androidprojectshoppinglist.ui.shoppinglist

import android.widget.CheckBox
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppingItem

@BindingAdapter("shoppingitemNameString")
fun CheckBox.setItemNameString(item: ShoppingItem?){
    item?.let {
        text = item.name
    }
}

@BindingAdapter("shoppingItemQuantityString")
fun  TextView.setItemQuantityString(item: ShoppingItem?){
    item?.let {
        text = item.quantity.toString()
    }
}
