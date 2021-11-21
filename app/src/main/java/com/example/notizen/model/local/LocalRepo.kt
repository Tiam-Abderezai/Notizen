package com.example.notizen.model.local

import android.app.Application
import com.example.notizen.model.NoteDatabase
import com.example.notizen.model.data.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn


class LocalRepo(private val application: Application) {
    private val TAG = "NoteRepository"
    private val noteDao by lazy {
        NoteDatabase.getDatabase(application).noteDao()
    }
    fun readAllData() = noteDao.readAllData().flowOn(Dispatchers.IO)

    suspend fun addNote(note: Note) {
        noteDao.addNote(note)
    }

    suspend fun editNote(note: Note) {
        noteDao.editNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    suspend fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }
}
