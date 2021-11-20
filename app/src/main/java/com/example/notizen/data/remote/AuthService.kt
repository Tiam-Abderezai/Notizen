package com.olayg.halfwayapp.repo.remote

import com.example.notizen.data.model.AuthResponse
import com.example.notizen.data.model.LoginBody
import com.example.notizen.data.model.RegisterBody
import retrofit2.http.*

interface AuthService {

    // Move your body, every every body

    @POST("/api/auth/register")
    suspend fun register(@Body body: RegisterBody): AuthResponse

    @POST("/api/auth/login")
    suspend fun login(@Body body: LoginBody): AuthResponse
}