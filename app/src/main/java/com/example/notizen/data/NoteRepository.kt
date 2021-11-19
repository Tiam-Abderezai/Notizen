package com.example.notizen.data

import android.app.Application
import com.example.notizen.data.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn


class NoteRepository(private val application: Application) {
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
