package com.example.androidprojectshoppinglist.ui.shoppinglistAddItem

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorsTest{
    @Test
    fun validateItemnameIsValid(){
        val itemname = "wortelen"
        val result = Validators.validateItemname(itemname)
        Assert.assertTrue(result)
    }

    @Test
    fun validateCategoryIsValid(){
        val category = "groenten"
        val result = Validators.validateCategory(category)
        Assert.assertTrue(result)
    }

    @Test
    fun validateQuantityIsValid(){
        val quantity = "10"
        val result = Validators.validateQuantity(quantity)
        Assert.assertTrue(result)

    }

    @Test
    fun validateItemnameIsNotValid(){
        val itemname = ""
        val result = Validators.validateItemname(itemname)
        Assert.assertFalse(result)
    }

    @Test
    fun validateCategoryIsNotValid(){
        val category = ""
        val result = Validators.validateCategory(category)
        Assert.assertFalse(result)
    }

    @Test
    fun validateEmptyQuantityIsNotValid(){
        val quantity = ""
        val result = Validators.validateQuantity(quantity)
        Assert.assertFalse(result)
    }

    @Test
    fun validatemoreThan100QuantityIsNotValid(){
        val quantity = "102"
        val result = Validators.validateQuantity(quantity)
        Assert.assertFalse(result)
    }

    @Test
    fun validatemoreLessThan1QuantityIsNotValid(){
        val quantity = "0"
        val result = Validators.validateQuantity(quantity)
        Assert.assertFalse(result)
    }


}

