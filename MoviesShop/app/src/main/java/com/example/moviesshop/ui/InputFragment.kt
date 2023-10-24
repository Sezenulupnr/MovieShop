package com.example.moviesshop.ui

import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviesshop.R
import com.example.moviesshop.common.viewBinding
import com.example.moviesshop.databinding.FragmentInputBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class InputFragment : Fragment(R.layout.fragment_input) {
    private val binding by viewBinding(FragmentInputBinding::bind)

    private lateinit var auth : FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        with(binding) {

            btnInput.setOnClickListener{
                val email = etMail.text.toString()
                val password = etPassword.text.toString()

                if (checkFields(email, password)) {
                    SignIn(email,password)
                }
            }
            buttonMember.setOnClickListener{
                findNavController().navigate(R.id.memberFragment)
            }
        }
    }

    private fun checkFields(email: String, password: String): Boolean {
        return when {
            Patterns.EMAIL_ADDRESS.matcher(email).matches().not() -> {
                binding.tilMail.error = "E-posta geçerli değil!"
                false
            }

            password.isEmpty() -> {
                binding.tilMail.isErrorEnabled = false
                binding.tilPassword.error = "Şifre boş!"
                false
            }

            password.length < 6 -> {
                binding.tilMail.isErrorEnabled = false
                binding.tilPassword.error = "Şifre en az 6 karakter olmalıdır!"
                false
            }

            else -> true
        }
    }

    private fun SignIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
            findNavController().navigate(R.id.inputToMovies)
        } .addOnFailureListener{
            Snackbar.make(requireView(), it.message.orEmpty(), 1000).show()
        }
    }
}


