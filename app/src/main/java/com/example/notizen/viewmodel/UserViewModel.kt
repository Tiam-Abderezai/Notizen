package com.example.notizen.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.notizen.data.model.RegisterResponse
import com.example.notizen.data.repo.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel (
    private val userRepo: UserRepository
) : ViewModel() {
    fun registerUser(body: RegisterResponse) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepo.registerUser(body)
        }
    }
}