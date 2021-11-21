package com.example.notizen.model.data.body

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginBody(
    val username: String,
    val password: String
)