package com.example.androidprojectshoppinglist.ui.waitingame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WaitinggameViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Waitinggame Fragment"
    }
    val text: LiveData<String> = _text
}