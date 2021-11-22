package com.example.notizen.model.remote

import android.util.Log
import com.example.notizen.model.data.response.AuthResponse
import com.example.notizen.model.data.body.LoginBody
import com.example.notizen.model.data.response.NoteResponse
import com.example.notizen.model.data.body.RegisterBody
import com.olayg.halfwayapp.repo.remote.RemoteInstance

object RemoteRepo {
    private val TAG = "AuthRepository"

    // AUTH functions
    suspend fun register(body: RegisterBody): AuthResponse {
        Log.d(TAG, "register: ")
        return RemoteInstance.authService.register(body)
    }

    suspend fun login(body: LoginBody): AuthResponse {
        Log.d(TAG, "login:")
        return RemoteInstance.authService.login(body)
    }

    // CRUD functions
//    suspend fun getNote(body: LoginBody): NoteResponse {
//        Log.d(TAG, "getNote: ")
//        return RemoteInstance.crudService.getNote(body)
//    }
    suspend fun getAllNotes(auth: Map<String, String>): List<NoteResponse> {
        Log.d(TAG, "getAllNotes: ")
        return RemoteInstance.crudService.getAllNotes(auth)
    }
    suspend fun addNote(note: Map<String, String>, auth: Map<String,String>): NoteResponse {
        Log.d(TAG, "addNote: ${RemoteInstance.crudService.addNote(note, auth).id}")
        return RemoteInstance.crudService.addNote(note, auth)
    }
    suspend fun deleteNote(id: String, auth: Map<String,String>): NoteResponse {
        Log.d(TAG, "deleteNote: ")
        return RemoteInstance.crudService.deleteNote(id, auth)
    }
//    suspend fun deleteAllNotes(auth: Map<String, String>): List<NoteResponse> {
//        Log.d(TAG, "deleteAllNotes: ")
//        return RemoteInstance.crudService.deleteAllNotes(auth)
//    }
//    suspend fun updateNote(body: NoteResponse): AuthResponse {
//        Log.d(TAG, "updateNote: ")
//        return RemoteInstance.authService.updateNote(body)
//    }
}