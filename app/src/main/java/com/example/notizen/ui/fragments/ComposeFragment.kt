package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.notizen.R
import com.example.notizen.model.local.LocalRepo
import com.example.notizen.model.data.Note
import com.example.notizen.databinding.FragmentComposeBinding
import com.example.notizen.viewmodel.NoteViewModel

class ComposeFragment : Fragment() {
    private lateinit var binding: FragmentComposeBinding
    private val TAG = "ComposeFragment"
    private val viewModel: NoteViewModel by viewModels {
        NoteViewModel.Factory(LocalRepo(requireActivity().application))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComposeBinding.inflate(inflater, container, false)
        binding.apply {
            btnSave.setOnClickListener {
                viewModel.addNote(Note(0,
                    etTitle.text.toString(),
                    etDescription.text.toString(),
                    false,
                    System.currentTimeMillis(),
                    System.currentTimeMillis()
                    ))
                findNavController().navigate(R.id.action_composeFragment_to_listFragment)
            }
        }
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }
}
