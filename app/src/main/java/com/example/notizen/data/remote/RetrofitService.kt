package com.olayg.halfwayapp.repo.remote

import com.example.notizen.data.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {


    @GET("/api/v1/ultimate/characters")
    suspend fun fetchUserData(
        @Query("name") name: String
    ): List<User>
}