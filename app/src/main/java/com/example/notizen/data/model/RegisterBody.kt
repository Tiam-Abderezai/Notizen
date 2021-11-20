package com.example.notizen.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
@JsonClass(generateAdapter = true)
data class RegisterBody(
    val username: String,
    val email: String,
    val password: String
//    val notes: List<Note>
)