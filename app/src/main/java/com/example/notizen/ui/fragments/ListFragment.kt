package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.notizen.ui.adapter.ListAdapter
//import com.example.notizen.viewmodel.RecipeViewModel
import com.example.notizen.R
import com.example.notizen.data.model.Note
import com.example.notizen.databinding.FragmentListBinding
import com.example.notizen.ui.adapter.NoteAdapter
import kotlinx.android.synthetic.main.activity_main.*

//import com.example.notizen.data.model.Recipe
//import com.example.notizen.data.repo.RecipeRepository
//import com.example.notizen.databinding.FragmentListBinding
//import com.example.notizen.utils.Globals
//import com.example.notizen.utils.Globals.Companion.TAG_FRAG_LIST
//import com.example.notizen.utils.Logger

class ListFragment : Fragment() {
    private val TAG = "ListFragment"
    private lateinit var binding: FragmentListBinding
//    private val viewModel: RecipeViewModel by viewModels {
//        RecipeViewModel.Factory(RecipeRepository(requireActivity().application))
//    }

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
                // dummy data
                val note1 = Note(1,"Nap","sleep and rest")
                val note2 = Note(1,"Eat","eat and drink")
                val note3 = Note(1,"Think","think and ponder")
                val notes = listOf(note1, note2, note3)
                adapter = NoteAdapter(notes)
            }
        }

//        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(requireContext())
//            binding.addNewRecipe.setOnClickListener {
//                findNavController().navigate(R.id.action_loginFragment_to_listFragment)
//            }
//        }
        setHasOptionsMenu(true)
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }
///////////////////////
// OVERRIDE METHODS  //
///////////////////////

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.recipes.observe(viewLifecycleOwner, Observer { recipes ->
        Log.d(TAG, "onViewCreated: ")
//            binding.recyclerView.adapter = ListAdapter(recipes)
//        })
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