package com.example.notizen.viewmodel

import androidx.lifecycle.*
import com.example.notizen.data.NoteRepository
import com.example.notizen.data.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class NoteViewModel(
    private val noteRepo: NoteRepository
) : ViewModel()  {

        val notes = noteRepo.readAllData().asLiveData(viewModelScope.coroutineContext + Dispatchers.Default)

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepo.addNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepo.updateNote(note)
        }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch(Dispatchers.IO){
            noteRepo.deleteNote(note)
        }
    }
    fun deleteAllNotes(){
        viewModelScope.launch(Dispatchers.IO){
            noteRepo.deleteAllNotes()
        }
    }
    class Factory(
        private val noteRepo: NoteRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
                return NoteViewModel(noteRepo) as T
            } else {
                throw IllegalArgumentException("Cannot create instance of ContactViewModel")
            }
        }
    }
}