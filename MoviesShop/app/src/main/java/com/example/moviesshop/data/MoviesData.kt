package com.example.moviesshop.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviesData(
    var movie_id: Int,
    var movie_title: String,
    var movie_photo: String,
    var movie_price: Double
): Parcelable
