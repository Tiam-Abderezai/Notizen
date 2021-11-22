package com.example.notizen.model.data.body

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class RegisterBody(
    val username: String,
    val email: String,
    val password: String
//    val notes: List<Note>
): Parcelable