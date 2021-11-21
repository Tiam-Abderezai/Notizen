package com.olayg.halfwayapp.repo.remote

import com.example.notizen.model.data.body.AuthResponse
import com.example.notizen.model.data.body.LoginBody
import com.example.notizen.model.data.body.NoteBody
import com.example.notizen.model.data.body.RegisterBody
import retrofit2.http.*

interface RemoteService {

    // Move your body, every every body

    // AUTH functions

    @POST("/api/auth/register")
    suspend fun register(@Body body: RegisterBody): AuthResponse

    @POST("/api/auth/login")
    suspend fun login(@Body body: LoginBody): AuthResponse

    // CRUD functions

    @GET("/api/auth/todos/{id}")
    suspend fun getNote(@Body body: NoteBody): AuthResponse

    @POST("/api/auth/todos")
    suspend fun getAllNotes(@Body body: NoteBody): AuthResponse

    @POST("/api/auth/todos")
    suspend fun addNote(@Body body: NoteBody): AuthResponse

    @PUT("/api/auth/todos/{id}")
    suspend fun updateNote(@Body body: NoteBody): AuthResponse

    @DELETE("/api/auth/todos/{id}")
    suspend fun deleteNote(@Body body: NoteBody): AuthResponse
}