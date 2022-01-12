package com.example.androidprojectshoppinglist.ui.shoppinglistAddItem

object Validators {
    fun validateItemname(itemname: String): Boolean {
        if(itemname.isEmpty()){
            return false
        }else if(itemname.isNotEmpty()){
            return true
        }
        return false
    }

    fun validateCategory(category: String): Boolean {
        if(category.isEmpty()){
            return false
        }else if(category.isNotEmpty()){
            return true
        }
        return false
    }

    fun validateQuantity(quantity: String): Boolean {
        if (quantity.isEmpty() || quantity.toIntOrNull() == null){
            return false
        }else if( quantity.toInt() > 100 || quantity.toInt() < 1){
            return false

        }else if(quantity.toInt() in 1..100){
            return true;
        }
        return false
    }

    fun validateForm(itemname: String, category: String, quantity: String): Boolean{
        return validateItemname(itemname) && validateCategory(category) && validateQuantity(quantity)
    }
}