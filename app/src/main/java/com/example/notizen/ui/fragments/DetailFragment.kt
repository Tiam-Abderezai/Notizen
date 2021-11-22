package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notizen.R
import com.example.notizen.model.local.LocalRepo
import com.example.notizen.databinding.FragmentDetailBinding
import com.example.notizen.viewmodel.LocalViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val args by navArgs<DetailFragmentArgs>()
    private val TAG = "DetailFragment"
    private val viewModel: LocalViewModel by viewModels {
        LocalViewModel.Factory(LocalRepo(requireActivity().application))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        binding.apply {
            chkCompleted.isChecked = args.note.completed
            Log.d(TAG, "onCreateView: ${args.note.completed}")
            tvTitle.text = args.note.title
            tvDescription.text = args.note.description
            btnDelete.setOnClickListener {
                viewModel.deleteNote(args.note)
                findNavController().navigate(R.id.listFragment)
            }
            btnEdit.setOnClickListener {
                val action = DetailFragmentDirections.actionDetailFragmentToEditFragment(args.note)
                findNavController().navigate(action)
            }
        }
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }
}


