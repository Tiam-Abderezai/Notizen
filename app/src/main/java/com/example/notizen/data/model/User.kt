package com.example.notizen.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val username: String,
    val email: String,
    val password: String,
    val notes: List<Note>
) : Parcelable