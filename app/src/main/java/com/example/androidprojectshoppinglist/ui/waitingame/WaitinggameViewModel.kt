package com.example.androidprojectshoppinglist.ui.waitingame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidprojectshoppinglist.network.waitinggame.JokeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WaitinggameViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getJokeProperties()
    }

    private fun getJokeProperties() {
        JokeApi.retrofitService.getProperties().enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }
        })
    }
}