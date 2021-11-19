package com.olayg.halfwayapp.repo.remote

import com.example.notizen.data.model.AuthResponse
import com.example.notizen.data.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.*

interface RetrofitService {

    @POST("/api/auth/register")
    suspend fun registerUser(@Body body: RegisterResponse): Response<AuthResponse>

    @POST("/api/auth/login")
    suspend fun loginUser(
        @Body map: Map<String, String>
    ): Response<RegisterResponse>

//    @GET("/api/v1/ultimate/characters")
//    suspend fun fetchUserData(
//        @Query("name") name: String
//    ): List<User>
}