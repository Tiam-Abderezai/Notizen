package com.example.notizen.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "note_database")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "completed") val completed: Boolean,
    @ColumnInfo(name = "date") val createdAt: Long,
    @ColumnInfo(name = "updatedAt") val updatedAt: Long
) : Parcelable