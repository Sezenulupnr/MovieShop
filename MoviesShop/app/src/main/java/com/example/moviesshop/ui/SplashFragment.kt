package com.example.moviesshop.ui

import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesshop.R
import com.example.moviesshop.common.viewBinding
import com.example.moviesshop.databinding.FragmentSplashBinding
import com.google.firebase.auth.FirebaseAuth

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val binding by viewBinding (FragmentSplashBinding::bind)

    private lateinit var auth: FirebaseAuth

    override fun onResume() {
        super.onResume()

        auth = FirebaseAuth.getInstance()

        // Belirli bir süre beklemek için Handler kullanın (3 saniye = 3000 milisaniye)
        Handler(Looper.getMainLooper()).postDelayed({
            if (auth.currentUser != null) {
                // Kullanıcı oturum açtıysa Input'a yönlendir
                findNavController().navigate(R.id.splashToMovie)
            }
            else {
                // Kullanıcı oturum açmamışsa Member'a yönlendir
                findNavController().navigate(R.id.splashToMember)
            }
        }, 3000)
    }

}