package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.notizen.R
import com.example.notizen.model.local.DataStore
import com.example.notizen.model.data.body.RegisterBody
import com.example.notizen.databinding.FragmentRegisterBinding
import com.example.notizen.viewmodel.RemoteViewModel
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    private val TAG = "RegisterFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.apply {
            btnRegister.setOnClickListener {
                lifecycleScope.launch {
                    RemoteViewModel.register(
                        RegisterBody(
                            etUsername.text.toString(),
                            etEmail.text.toString(),
                            etPassword.text.toString()
                        )
                    ).apply {
                        context?.let {
                            DataStore(it).setToken(token)
                            DataStore(it).setUsername(etUsername.text.toString())
                            DataStore(it).setEmail(etEmail.text.toString())
                            DataStore(it).setPassword(etPassword.text.toString())
                        }
                        Log.d(TAG, "onCreateView: token:$token message:$message")
                        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                    }
                }
            }
        }
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated:")
    }
}
