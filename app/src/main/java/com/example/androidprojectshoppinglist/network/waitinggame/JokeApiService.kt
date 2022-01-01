package com.example.androidprojectshoppinglist.network.waitinggame

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.jokes.one/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface JokeApiService {
    @GET("jod")
    suspend fun getJoke(): ContentWithJokes
}

object JokeApi {
    val retrofitService : JokeApiService by lazy {
        retrofit.create(JokeApiService::class.java)
    }
}