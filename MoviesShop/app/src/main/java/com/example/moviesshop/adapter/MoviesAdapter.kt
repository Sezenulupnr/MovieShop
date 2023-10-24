package com.example.moviesshop.adapter

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesshop.data.MoviesData
import com.example.moviesshop.R
import com.google.firebase.auth.FirebaseAuth

class MoviesAdapter (
    private val mContext: Context , private val MoviesList:List<MoviesData>
) :RecyclerView.Adapter<MoviesAdapter.ObjectHolder>() {

        inner class ObjectHolder(view:View):RecyclerView.ViewHolder(view) {
            var movieTitle : TextView
            var moviePrice : TextView
            var moviePhoto : ImageView
            var buttonShopping : Button

            init {
                movieTitle = view.findViewById(R.id.movie_title)
                moviePrice = view.findViewById(R.id.movie_price)
                moviePhoto = view.findViewById(R.id.movie_photo)
                buttonShopping = view.findViewById(R.id.button_shopping)
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.movie_layout,parent,false)
        return ObjectHolder(design)
    }

    override fun getItemCount(): Int {
        return MoviesList.size
    }

    override fun onBindViewHolder(holder: ObjectHolder, position: Int) {
        val movie = MoviesList[position]

        holder.movieTitle.text = movie.movie_title
        holder.moviePrice.text = "${movie.movie_price} TL"
        holder.moviePhoto.setImageResource(
            mContext.resources.getIdentifier(movie.movie_photo,"drawable",mContext.packageName))

        holder.buttonShopping.setOnClickListener{
            Toast.makeText(mContext,"${movie.movie_title} Sepete Eklendi",Toast.LENGTH_SHORT).show()
        }

    }
}