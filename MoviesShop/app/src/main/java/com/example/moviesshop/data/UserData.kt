package com.example.moviesshop.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    val name: String,
    val mail: String,
    val phone: Int,
    val password: String,
): Parcelable
