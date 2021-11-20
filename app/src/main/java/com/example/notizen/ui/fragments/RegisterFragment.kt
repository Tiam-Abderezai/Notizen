package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.notizen.data.model.LoginBody
import com.example.notizen.data.model.RegisterBody
import com.example.notizen.databinding.FragmentRegisterBinding
import com.example.notizen.viewmodel.AuthViewModel
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
                lifecycleScope.launch{
                    AuthViewModel.register(RegisterBody(
                        etUsername.text.toString(),
                        etEmail.text.toString(),
                        etPassword.text.toString()
                    )).apply {
                        Log.d(TAG, "onCreateView: token:$token message:$message")
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
