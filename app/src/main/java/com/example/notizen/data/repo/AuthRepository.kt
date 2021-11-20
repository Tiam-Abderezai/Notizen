package com.example.notizen.data.repo

import android.util.Log
import com.example.notizen.data.model.AuthResponse
import com.example.notizen.data.model.LoginBody
import com.example.notizen.data.model.RegisterBody
import com.olayg.halfwayapp.repo.remote.RetrofitInstance
import java.lang.Exception

object AuthRepository {
    private val TAG = "AuthRepository"

    suspend fun register(registerInfo: RegisterBody): AuthResponse {
        return RetrofitInstance.authService.register(registerInfo)
    }

    suspend fun login(loginInfo: LoginBody): AuthResponse {
        Log.d(TAG, "login:")
        return RetrofitInstance.authService.login(loginInfo)
    }

}