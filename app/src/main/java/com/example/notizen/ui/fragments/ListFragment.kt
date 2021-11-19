package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notizen.R
import com.example.notizen.data.repo.NoteRepository
import com.example.notizen.databinding.FragmentListBinding
import com.example.notizen.ui.adapter.NoteAdapter
import com.example.notizen.viewmodel.NoteViewModel


class ListFragment : Fragment() {
    private val TAG = "ListFragment"
    private lateinit var binding: FragmentListBinding
    private val viewModel: NoteViewModel by viewModels {
        NoteViewModel.Factory(NoteRepository(requireActivity().application))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.apply {
            btnCompose.setOnClickListener {
                findNavController().navigate(R.id.action_listFragment_to_composeFragment)
            }
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
//                val note1 = Note(1,"Nap","sleep and rest")
//                val note2 = Note(1,"Eat","eat and drink")
//                val note3 = Note(1,"Think","think and ponder")
//                val notes = listOf(note1, note2, note3)
//                adapter = NoteAdapter(notes)
            }
        }

        setHasOptionsMenu(true)
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }
///////////////////////
// OVERRIDE METHODS  //
///////////////////////

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.notes.observe(viewLifecycleOwner, { notes ->
        Log.d(TAG, "onViewCreated: $notes")
            binding.recyclerView.adapter = NoteAdapter(notes)
        })
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.delete_menu, menu)
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.menu_delete) {
//            deleteAllRecipes()
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//    private fun deleteAllRecipes() {
//        val builder = AlertDialog.Builder(requireContext())
//        builder.setPositiveButton("Yes") { _, _ ->
//            viewModel.deleteAllRecipes()
//            Toast.makeText(
//                requireContext(),
//                "Successfully removed everything",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//        builder.setNegativeButton("No") { _, _ ->
//
//        }
//        builder.setTitle("Delete everything?")
//        builder.setMessage("Are you sure you want to delete everything?")
//        builder.create().show()
//    }
}