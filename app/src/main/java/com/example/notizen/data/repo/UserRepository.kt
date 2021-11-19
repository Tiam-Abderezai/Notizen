package com.example.notizen.data.repo

import android.util.Log
import com.example.notizen.data.model.RegisterResponse
import com.olayg.halfwayapp.repo.remote.RetrofitInstance
import java.lang.Exception

class UserRepository {
    private val TAG = "UserRepository"
    private val serviceApi by lazy {
        RetrofitInstance.userService
    }
    suspend fun registerUser(body: RegisterResponse) = try {
        serviceApi.registerUser(body).raw().apply {
            Log.d(TAG, "registerUser: ${this.headers()}")
        }
    } catch (ex: Exception) {
        Log.d(TAG, "registerUserEx: ${ex}")
    }

    suspend fun loginUser(map: Map<String, String>) = try {
        serviceApi.loginUser(map).apply {
            Log.d(TAG, "loginUser: ${this.body()} ")
        }
    } catch (ex: Exception){
        Log.d(TAG, "loginUserEx: ${ex.message}")
    }

}