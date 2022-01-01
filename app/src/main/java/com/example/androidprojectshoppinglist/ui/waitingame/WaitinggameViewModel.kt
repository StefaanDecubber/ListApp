package com.example.androidprojectshoppinglist.ui.waitingame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidprojectshoppinglist.network.waitinggame.JokeApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class WaitinggameViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getJokeProperties()
    }

    private fun getJokeProperties() {
        viewModelScope.launch {
            try {
                var result = JokeApi.retrofitService.getJoke()
                //.contents?.jokes?.get(0)?.joke?.text
                _response.value = "Succes: ${result.contents?.jokes?.get(0)?.joke?.text}"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}