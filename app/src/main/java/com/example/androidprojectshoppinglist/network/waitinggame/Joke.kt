package com.example.androidprojectshoppinglist.network.waitinggame

data class ContentWithJokes (
    val contents: Jokes
)

data class Jokes(
    val jokes: List<Joke>
)

data class Joke(
    val description: String,
    val language: String,
    val category: String,
    val date: String,
    val joke: JokeDetail
)

data class JokeDetail(
    val title: String,
    val lang: String,
    val length: String,
    val text: String
)

