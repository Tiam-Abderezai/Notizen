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
    private var displayNotes = mutableListOf<Note>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycleScope.launch {
            if (!context?.let { DataStore(it).getToken() }.isNullOrEmpty()) {
                token = DataStore(requireActivity()).getToken().toString()
                Log.d(TAG, "tokenCheck:${DataStore(requireContext()).getToken()}")
            }
//            findNavController().navigate(R.id.action_loginFragment_to_listFragment)
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
            displayNotes.clear()
            displayNotes.apply {
                forEachIndexed { index, _ ->
                    add(notes[index])
                    Log.d(TAG, "onViewCreated:${notes[index]} ")
                }
            }
        })
        lifecycleScope.launch {
            try {
                val auth = HashMap<String, String>()
                auth["Authorization"] = token
                RemoteViewModel.getAllNotes(
                    auth
                ).apply {
                    Log.d(TAG, "onCreateView: all Notes size: ${this.size}")
                }
            } catch (ex: Exception) {
                Log.d(TAG, "onCreateView: $ex")
            }
        }

        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }

    private var simpleCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP.or(ItemTouchHelper.DOWN), 0){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            var positionStart = viewHolder.adapterPosition
            var positionEnd = target.adapterPosition
            try {
                Collections.swap(displayNotes, positionStart, positionEnd)
                binding.recyclerView.adapter?.notifyItemMoved(positionStart, positionEnd)
            } catch(ex: Exception){
                Log.d(TAG, "onMove: $ex")
            }
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            TODO("Not yet implemented")
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_top, menu)
        val item: MenuItem = menu.findItem(R.id.action_search)
        item.let {
            val searchView = it.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?) = true

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText.isNullOrEmpty()) {
//                        displayNotes.clear()
                        val search = newText?.lowercase(Locale.getDefault())
                        displayNotes.apply {
                            forEachIndexed() { index, element ->
                                if (element.title.lowercase(Locale.getDefault())
                                        .contains(search!!)
                                ) {
                                    add(element)

                                }
                                binding.recyclerView.adapter?.notifyDataSetChanged()
                            }
                        }

                    } else {
                        displayNotes.apply {
                            clear()
                            addAll(displayNotes)
                            binding.recyclerView.adapter?.notifyDataSetChanged()
                        }

                    }

                    return true
                }
            })
        }
        super.onCreateOptionsMenu(menu, inflater)

    }
}