package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.notizen.R
import com.example.notizen.data.model.LoginBody
import com.example.notizen.databinding.FragmentLoginBinding
import com.example.notizen.viewmodel.AuthViewModel
import kotlinx.coroutines.launch
import java.lang.Exception


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val TAG = "LoginFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.apply {
            btnLogin.setOnClickListener {
                lifecycleScope.launch { 
                    try {
                        AuthViewModel.login(
                            LoginBody(
                                etUsername.text.toString(),
                                etPassword.text.toString()
                            )
                        ).apply {
                            Log.d(TAG, "onCreateView: token: $token message: $message")
                            findNavController().navigate(R.id.action_loginFragment_to_listFragment)
                        }
                    } catch (ex: Exception){
                        Log.d(TAG, "onCreateView: $ex")
                    }
                }
            }
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }

}