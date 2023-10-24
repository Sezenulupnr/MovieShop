package com.example.moviesshop.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.moviesshop.R
import com.example.moviesshop.adapter.MoviesAdapter
import com.example.moviesshop.common.viewBinding
import com.example.moviesshop.data.MoviesData
import com.example.moviesshop.databinding.FragmentMoviesBinding
import java.util.ArrayList

class MoviesFragment : Fragment(R.layout.fragment_movies) {
    private val binding by viewBinding (FragmentMoviesBinding::bind)

    private lateinit var moviesArrayList: ArrayList<MoviesData>
    private lateinit var adapter: MoviesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.rvMovies.setHasFixedSize(true)
        binding.rvMovies.layoutManager =
            StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val f1 = MoviesData(1, "YEŞİL YOL", "yesilyol", 34.99)
        val f2 = MoviesData(2, "BIR ZAMANLAR ANADOLUDA", "birzamanlaranadoluda", 39.99)
        val f3 = MoviesData(3, "INCEPTION", "inception", 59.99)
        val f4 = MoviesData(4, "THE HATEFUL EIGHT", "thehatefuleight", 54.99)
        val f5 = MoviesData(5, "THE PIANIST", "thepianist", 49.99)
        val f6 = MoviesData(6, "INTERSTELLAR", "interstellar", 44.99)
        val f7 = MoviesData(7, "SNATCH", "snatch", 59.99)
        val f8 = MoviesData(8, "DJANGO", "django", 54.99)
        val f9 = MoviesData(9, "DÖVÜŞ KULUBÜ ", "dovusklubu", 44.99)
        val f10 = MoviesData(10, "TİTANİK", "titanic", 34.99)
        val f11 = MoviesData(11, "YÜZÜKLERİN EFENDİSİ", "yuzuklerinefendisi", 44.99)
        val f12 = MoviesData(12, "PRESTİJ", "prestij", 44.99)
        val f13 = MoviesData(13, "KARAYİP KORSANLARI", "karayipkorsanlari", 44.99)
        val f14 = MoviesData(14, "AVATAR", "avatar", 54.99)

        moviesArrayList = ArrayList<MoviesData>()
        moviesArrayList.add(f1)
        moviesArrayList.add(f2)
        moviesArrayList.add(f3)
        moviesArrayList.add(f4)
        moviesArrayList.add(f5)
        moviesArrayList.add(f6)
        moviesArrayList.add(f7)
        moviesArrayList.add(f8)
        moviesArrayList.add(f9)
        moviesArrayList.add(f10)
        moviesArrayList.add(f11)
        moviesArrayList.add(f12)
        moviesArrayList.add(f13)
        moviesArrayList.add(f14)

        adapter = MoviesAdapter(requireContext(), moviesArrayList)
        binding.rvMovies.adapter = adapter


    }

}