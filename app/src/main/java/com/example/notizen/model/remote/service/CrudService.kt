package com.example.notizen.model.remote.service

import com.example.notizen.model.data.body.LoginBody
import com.example.notizen.model.data.response.NoteResponse
import retrofit2.http.*

interface CrudService {

    // Move your body, every every body

    // CRUD functions //

//    @GET("todos/{id}")
//    suspend fun getNote(@Path("id") id: String, @HeaderMap headers: Map<String, String>): NoteResponse

    @GET("todos")
    suspend fun getAllNotes(@HeaderMap auth: Map<String, String>): List<NoteResponse>

    @POST("todos")
    suspend fun addNote(@Body note: Map<String, String>, @HeaderMap auth: Map<String, String>): NoteResponse

//    @PUT("todos/{id}")
//    suspend fun updateNote(@Path("id") id:String, @Body body: LoginBody, @HeaderMap headers: Map<String, String>): NoteResponse

    @DELETE("todos/{id}")
    suspend fun deleteNote(@Path("id") id: String, @HeaderMap auth: Map<String, String>): NoteResponse
}