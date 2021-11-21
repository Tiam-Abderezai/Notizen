package com.example.notizen.model
import androidx.room.*
import com.example.notizen.model.data.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_database")
    fun readAllData(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note)

    @Update
    suspend fun editNote(note: Note)

    @Delete
    suspend fun deleteNote (note: Note)

    @Query("DELETE FROM note_database")
    suspend fun deleteAllNotes()

}