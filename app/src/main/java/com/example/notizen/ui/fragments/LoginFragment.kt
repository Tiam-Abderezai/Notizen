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
import com.example.notizen.model.local.DataStore
import com.example.notizen.model.data.body.LoginBody
import com.example.notizen.databinding.FragmentLoginBinding
import com.example.notizen.viewmodel.RemoteViewModel
import kotlinx.coroutines.launch
import java.lang.Exception


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val TAG = "LoginFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycleScope.launch {
           if(!context?.let { DataStore(it).getToken() }.isNullOrEmpty()){
               findNavController().navigate(R.id.action_loginFragment_to_listFragment)
               Log.d(TAG, "tokenCheck:${DataStore(requireContext()).getToken()}")
           }
        }

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.apply {
            btnLogin.setOnClickListener {
                lifecycleScope.launch { 
                    try {
                        RemoteViewModel.login(
                            LoginBody(
                                etUsername.text.toString(),
                                etPassword.text.toString()
                            )
                        ).apply {
                            Log.d(TAG, "onCreateView: token: $token message: $message")
                            context?.let { DataStore(it).setToken(token)
                                DataStore(it).setUsername(etUsername.text.toString())
                                DataStore(it).setPassword(etPassword.text.toString())
                            }
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