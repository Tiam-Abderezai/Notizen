package com.example.notizen.model.data.body

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NoteBody(
    val title: String,
    val description: String,
    val completed: Boolean,
)