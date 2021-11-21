package com.olayg.halfwayapp.repo.remote

import com.example.notizen.model.remote.service.AuthService
import com.example.notizen.model.remote.service.CrudService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RemoteInstance {

    private const val BASE_URL = "https://knex-todo.herokuapp.com/api/"

    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val authService: AuthService =
        retrofit.create(AuthService::class.java)
    val crudService: CrudService =
        retrofit.create(CrudService::class.java)
}