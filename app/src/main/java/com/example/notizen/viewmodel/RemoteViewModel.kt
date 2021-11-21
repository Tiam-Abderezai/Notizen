package com.example.notizen.viewmodel


import androidx.lifecycle.ViewModel
import com.example.notizen.model.data.body.LoginBody
import com.example.notizen.model.data.response.NoteResponse
import com.example.notizen.model.data.body.RegisterBody
import com.example.notizen.model.remote.RemoteRepo

object RemoteViewModel : ViewModel() {
    // AUTH functions //
    suspend fun register(body: RegisterBody) = RemoteRepo.register(body)
    suspend fun login(body: LoginBody) = RemoteRepo.login(body)
    // CRUD functions //
    suspend fun addNote(note: Map<String, String>, auth: Map<String, String>) = RemoteRepo.addNote(note, auth)
//    suspend fun getNote(body: NoteResponse) = RemoteRepo.getNote(body)
    suspend fun getAllNotes(auth: Map<String, String>) = RemoteRepo.getAllNotes(auth)
    suspend fun deleteNote(id: String, auth: Map<String, String>) = RemoteRepo.deleteNote(id, auth)
//    suspend fun deleteAllNotes(auth: Map<String, String>) = RemoteRepo.deleteAllNotes(auth)

//    suspend fun updateNote(body: NoteResponse) = RemoteRepo.updateNote(body)
}