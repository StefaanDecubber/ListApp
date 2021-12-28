package com.example.androidprojectshoppinglist.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hey fellow programmer! \n\n" +
                "Here is an app where you can create a shopping list and while waiting " +
                "in the line, you can play a little game to pass time."

    }
    val text: LiveData<String> = _text
}