package com.example.moviesshop.ui

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.moviesshop.R
import com.example.moviesshop.common.viewBinding
import com.example.moviesshop.databinding.FragmentMemberBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class MemberFragment : Fragment(R.layout.fragment_member) {
    private val binding by viewBinding(FragmentMemberBinding::bind)

    private lateinit var auth : FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        with(binding) {
            btnMember.setOnClickListener{
                val email = etMailMember.text.toString()
                val password = etPasswordMember.text.toString()

                if (checkFields(email, password)) {
                    SignUp(email,password)
                }
            }
            buttonInput.setOnClickListener{
                findNavController().navigate(R.id.inputFragment)
            }
        }
    }

    private fun checkFields(email: String, password: String): Boolean {
        return when{
            Patterns.EMAIL_ADDRESS.matcher(email).matches().not() -> {
                binding.tilMailMember.error = "E-posta geçerli değil!"
                false
            }

            password.isEmpty() -> {
                binding.tilMailMember.isErrorEnabled = false
                binding.tilPasswordMember.error = "Şifre boş!"
                false
            }

            password.length < 6 -> {
                binding.tilMailMember.isErrorEnabled = false
                binding.tilPasswordMember.error = "Şifre en az 6 karakter olmalıdır!"
                false
            }
            else -> true
        }
    }

    private fun SignUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
            findNavController().navigate(R.id.memberToMovies)
        } .addOnFailureListener{
            Snackbar.make(requireView(), it.message.orEmpty(), 1000).show()
        }
    }
}
