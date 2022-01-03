package com.example.androidprojectshoppinglist.model

enum class FormValidationErrorTags {
    INVALID_NAME,
    INVALID_CATEGORY,
    INVALID_QUANTITY,
    UNKNOWN;

    companion object {
        fun getType(name: String): FormValidationErrorTags {
            return values().find { it.name == name } ?: UNKNOWN
        }
    }
}