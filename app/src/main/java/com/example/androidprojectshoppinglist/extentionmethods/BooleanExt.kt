package com.example.androidprojectshoppinglist.extentionmethods

fun Boolean?.orTrue() = this ?: true

fun Boolean?.orFalse() = this ?: false

fun Boolean.reverse() = this.not()