package com.example.notizen.model.remote.service

import com.example.notizen.model.data.Note
import com.example.notizen.model.data.response.AuthResponse
import com.example.notizen.model.data.body.LoginBody
import com.example.notizen.model.data.response.NoteResponse
import com.example.notizen.model.data.body.RegisterBody
import retrofit2.http.*

interface AuthService {

    // Move your body, every every body

    // AUTH functions //

    @POST("auth/register")
    suspend fun register(@Body body: RegisterBody): AuthResponse

    @POST("auth/login")
    suspend fun login(@Body body: LoginBody): AuthResponse

}