package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.notizen.R
import com.example.notizen.model.local.LocalRepo
import com.example.notizen.model.data.Note
import com.example.notizen.databinding.FragmentComposeBinding
import com.example.notizen.model.data.body.LoginBody
import com.example.notizen.model.data.response.NoteResponse
import com.example.notizen.model.local.DataStore
import com.example.notizen.viewmodel.LocalViewModel
import com.example.notizen.viewmodel.RemoteViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class ComposeFragment : Fragment() {
    private lateinit var binding: FragmentComposeBinding
    private val TAG = "ComposeFragment"
    private lateinit var token: String
    private lateinit var username: String
    private lateinit var password: String

    private val localVM: LocalViewModel by viewModels {
        LocalViewModel.Factory(LocalRepo(requireActivity().application))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycleScope.launch {
            if (!context?.let { DataStore(it).getToken() }.isNullOrEmpty()) {
                token = DataStore(requireActivity()).getToken().toString()
                username = DataStore(requireActivity()).getUsername().toString()
                password = DataStore(requireActivity()).getPassword().toString()
                Log.d(TAG, "tokenCheck:${DataStore(requireContext()).getToken()}")
                Log.d(TAG, "usernameCheck:${DataStore(requireContext()).getUsername()}")
                Log.d(TAG, "passwordCheck:${DataStore(requireContext()).getPassword()}")

            }
//            findNavController().navigate(R.id.action_loginFragment_to_listFragment)
        }
        binding = FragmentComposeBinding.inflate(inflater, container, false)
        binding.apply {
            btnSave.setOnClickListener {
                lifecycleScope.launch {
                    try {
                        Log.d(TAG, "onCreateView: Token:$token")
                        val auth = HashMap<String, String>()
                        val note = HashMap<String, String>()
                        auth["Authorization"] = token
                        note["title"] = etTitle.text.toString()
                        note["description"] = etDescription.text.toString()
                        note["completed"] = "false"
                        note["date"] = System.currentTimeMillis().toString()
                        note["updatedAt"] = System.currentTimeMillis().toString()
                        RemoteViewModel.addNote(
                            note,
                            auth
                        )
                        RemoteViewModel.login(
                            LoginBody(
                                username,
                                password
                            )
                        ).apply {
                            saveNote(
                                Note(
                                    0,
                                    etTitle.text.toString(),
                                    etDescription.text.toString(),
                                    false,
                                    System.currentTimeMillis().toString(),
                                    System.currentTimeMillis().toString()
                                )
                            )
                            findNavController().navigate(R.id.action_composeFragment_to_listFragment)
                        }
                    } catch (ex: Exception) {
                        Log.d(TAG, "onCreateView: $ex")
                    }
                }
            }
        }
        return binding.root
    }

    private fun saveNote(note: Note) {
        localVM.addNote(
            Note(
                0,
                note.title,
                note.description,
                note.completed,
                note.createdAt,
                note.updatedAt
            )
        )
    }
}
