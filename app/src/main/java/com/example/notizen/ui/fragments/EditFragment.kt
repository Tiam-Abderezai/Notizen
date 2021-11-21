package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notizen.R
import com.example.notizen.model.local.LocalRepo
import com.example.notizen.model.data.Note
import com.example.notizen.databinding.FragmentEditBinding
import com.example.notizen.viewmodel.NoteViewModel


class EditFragment : Fragment() {
    private val TAG = "EditFragment"
    private lateinit var binding: FragmentEditBinding
    private val args by navArgs<EditFragmentArgs>()
    private val viewModel: NoteViewModel by viewModels {
        NoteViewModel.Factory(LocalRepo(requireActivity().application))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)

        binding.apply {
            etTitle.setText(args.note.title)
            etDescription.setText(args.note.description)
            btnSave.setOnClickListener {
                viewModel.editNote(Note(args.note.id, etTitle.text.toString(),
                    etDescription.text.toString(),
                    false,
                    args.note.createdAt,
                    System.currentTimeMillis()
                ))
                findNavController().navigate(R.id.action_editFragment_to_listFragment)
            }
        }
        setHasOptionsMenu(true)
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }
}