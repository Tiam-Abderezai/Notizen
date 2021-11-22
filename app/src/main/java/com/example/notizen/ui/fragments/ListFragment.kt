package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notizen.R
import com.example.notizen.model.local.LocalRepo
import com.example.notizen.databinding.FragmentListBinding
import com.example.notizen.model.data.Note
import com.example.notizen.model.data.body.LoginBody
import com.example.notizen.model.local.DataStore
import com.example.notizen.ui.adapter.NoteAdapter
import com.example.notizen.viewmodel.LocalViewModel
import com.example.notizen.viewmodel.RemoteViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*
import kotlin.collections.HashMap


class ListFragment : Fragment() {
    private val TAG = "ListFragment"
    private lateinit var binding: FragmentListBinding
    private lateinit var token: String
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
                Log.d(TAG, "tokenCheck:${DataStore(requireContext()).getToken()}")
            }
        }
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.apply {
            btnCompose.setOnClickListener {
                findNavController().navigate(R.id.action_listFragment_to_composeFragment)
            }
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

        setHasOptionsMenu(true)
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        localVM.notes.observe(viewLifecycleOwner, { notes ->
            Log.d(TAG, "onViewCreated: $notes")
            binding.recyclerView.adapter = NoteAdapter(notes)
        })
        lifecycleScope.launch {
            try {
                val auth = HashMap<String, String>()
                auth["Authorization"] = token
                RemoteViewModel.getAllNotes(
                    auth
                ).apply {
                    Log.d(TAG, "onCreateView: all Notes size: ${this[1].id}")
                }
            } catch (ex: Exception) {
                Log.d(TAG, "onCreateView: $ex")
            }
        }
    }

}