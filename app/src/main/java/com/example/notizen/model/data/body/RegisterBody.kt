package com.example.notizen.model.data.body

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegisterBody(
    val username: String,
    val email: String,
    val password: String
//    val notes: List<Note>
)