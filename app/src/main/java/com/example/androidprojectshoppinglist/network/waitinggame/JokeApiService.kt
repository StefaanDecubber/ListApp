package com.example.androidprojectshoppinglist.network.waitinggame

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.jokes.one/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

/*
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

 */

interface JokeApiService {
    @GET("jod")
    fun getProperties(): Call<String>
}

object JokeApi {
    val retrofitService : JokeApiService by lazy {
        retrofit.create(JokeApiService::class.java)
    }
}