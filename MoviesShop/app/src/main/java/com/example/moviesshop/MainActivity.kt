package com.example.moviesshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesshop.common.viewBinding
import com.example.moviesshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding (ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}