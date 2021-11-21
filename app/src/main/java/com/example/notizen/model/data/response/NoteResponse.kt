package com.example.notizen.model.data.response

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class NoteResponse(
    val id: Int?,
    val title: String?,
    val description: String?,
    val completed: Boolean?,
    val date: String?,
    val updatedAt: String?,
) : Parcelable
