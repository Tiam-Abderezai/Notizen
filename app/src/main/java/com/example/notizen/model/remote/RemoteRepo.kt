package com.example.notizen.model.remote

import android.util.Log
import com.example.notizen.model.data.body.AuthResponse
import com.example.notizen.model.data.body.LoginBody
import com.example.notizen.model.data.body.NoteBody
import com.example.notizen.model.data.body.RegisterBody
import com.olayg.halfwayapp.repo.remote.RemoteInstance

object RemoteRepo {
    private val TAG = "AuthRepository"

    // AUTH functions
    suspend fun register(body: RegisterBody): AuthResponse {
        return RemoteInstance.authService.register(body)
    }

    suspend fun login(body: LoginBody): AuthResponse {
        Log.d(TAG, "login:")
        return RemoteInstance.authService.login(body)
    }

    // CRUD functions
    suspend fun getNote(body: NoteBody): AuthResponse {
        return RemoteInstance.authService.getNote(body)
    }
    suspend fun getAllNotes(body: NoteBody): AuthResponse {
        return RemoteInstance.authService.getAllNotes(body)
    }
    suspend fun addNote(body: NoteBody): AuthResponse {
        return RemoteInstance.authService.addNote(body)
    }
    suspend fun deleteNote(body: NoteBody): AuthResponse {
        return RemoteInstance.authService.deleteNote(body)
    }
    suspend fun updateNote(body: NoteBody): AuthResponse {
        return RemoteInstance.authService.updateNote(body)
    }
}