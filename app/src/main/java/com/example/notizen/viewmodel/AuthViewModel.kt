package com.example.notizen.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.notizen.data.model.LoginBody
import com.example.notizen.data.model.RegisterBody
import com.example.notizen.data.repo.AuthRepository

object AuthViewModel : ViewModel() {
    suspend fun register(body: RegisterBody) = AuthRepository.register(body)

    suspend fun login(body: LoginBody) = AuthRepository.login(body)
}