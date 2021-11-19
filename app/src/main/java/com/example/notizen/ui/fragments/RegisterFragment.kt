package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.notizen.data.repo.UserRepository
import androidx.fragment.app.viewModels
import com.example.notizen.data.model.RegisterResponse
import com.example.notizen.databinding.FragmentRegisterBinding
import com.example.notizen.viewmodel.UserViewModel

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

        private val viewModel: UserViewModel by activityViewModels()
    private val TAG = "RegisterFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
//        binding.addBtn.setOnClickListener {
//            insertDataToDatabase()
//        }
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated:")
//            if (this.readChars(context).isNullOrEmpty()) {
//                Log.d(TAG, "onViewCreated: ${this.readChars(context).toString()}")
        viewModel.apply {
            registerUser(RegisterResponse(
                "raphael",
                "ninja@turtles.com",
                "pizza1234"
            ))
            Log.d(TAG, "userViewModel: $this")
        }
    }
}
