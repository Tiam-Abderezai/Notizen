package com.example.notizen.viewmodel


import androidx.lifecycle.ViewModel
import com.example.notizen.model.data.body.LoginBody
import com.example.notizen.model.data.body.RegisterBody
import com.example.notizen.model.remote.RemoteRepo

object AuthViewModel : ViewModel() {
    suspend fun register(body: RegisterBody) = RemoteRepo.register(body)

    suspend fun login(body: LoginBody) = RemoteRepo.login(body)
}