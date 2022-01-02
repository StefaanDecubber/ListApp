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
    private val _joke = MutableLiveData<String>()
    private val _titleJoke = MutableLiveData<String>()
    val joke: LiveData<String>
        get() = _joke
    val titleJoke: LiveData<String>
        get() = _titleJoke

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getJokeProperties()
    }

    private fun getJokeProperties() {
        viewModelScope.launch {
            try {
                val result = JokeApi.retrofitService.getJoke()
                //.contents?.jokes?.get(0)?.joke?.text
                _titleJoke.value = result.contents?.jokes?.get(0)?.joke?.title
                _joke.value = result.contents?.jokes?.get(0)?.joke?.text
            } catch (e: Exception) {
                _titleJoke.value = "Failure getting data: ${e.message}"
                _joke.value = "Q: What does Santa say when he's taking attendance at school?\nA:Present"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}