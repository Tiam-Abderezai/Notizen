package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notizen.R
import com.example.notizen.data.NoteRepository
import com.example.notizen.data.model.Note
import com.example.notizen.databinding.FragmentEditBinding
import com.example.notizen.viewmodel.NoteViewModel


class EditFragment : Fragment() {
    private val TAG = "EditFragment"
    private lateinit var binding: FragmentEditBinding
    private val args by navArgs<EditFragmentArgs>()
    private val viewModel: NoteViewModel by viewModels {
        NoteViewModel.Factory(NoteRepository(requireActivity().application))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater, container, false)

        binding.apply {
            etTitle.setText(args.note.title)
            etDescription.setText(args.note.description)
            btnSave.setOnClickListener {
                viewModel.editNote(Note(args.note.id, etTitle.text.toString(), etDescription.text.toString()))
                findNavController().navigate(R.id.action_editFragment_to_listFragment)
            }
        }

        setHasOptionsMenu(true)
        Log.d(TAG, "onCreateView: ")
//        Logger.logd(TAG_FRAG_UPDATE, "onCreateView")

        return binding.root
    }

//    private fun updateItem() {
//        val name = binding.etUpdateName.text.toString()
//        val description = binding.etUpdateDescription.text.toString()
//        val ingredients = listOf(
//            binding.etUpdateIngredient1.text.toString(),
//            binding.etUpdateIngredient2.text.toString(),
//            binding.etUpdateIngredient3.text.toString(),
//            binding.etUpdateIngredient4.text.toString(),
//            binding.etUpdateIngredient5.text.toString()
//        )
//        if (inputCheck(name, description)) {
//            val updatedRecipe = Recipe(args.currentRecipe.id, name, description, ingredients)
//            viewModel.updateRecipe(updatedRecipe)
//            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
//            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT)
//                .show()
//        }
//    }
//
//    private fun inputCheck(name: String, description: String) =
//        !(TextUtils.isEmpty(name) && TextUtils.isEmpty(description))
//
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.delete_menu, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.menu_delete) {
//            deleteRecipe()
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//    private fun deleteRecipe() {
//        val builder = AlertDialog.Builder(requireContext())
//        builder.setPositiveButton("Yes") { _, _ ->
//            viewModel.deleteRecipe(args.currentRecipe)
//            Toast.makeText(
//                requireContext(),
//                "Successfully removed: ${args.currentRecipe.name}",
//                Toast.LENGTH_SHORT
//            ).show()
//            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
//        }
//        builder.setNegativeButton("No") { _, _ ->
//
//        }
//        builder.setTitle("Delete ${args.currentRecipe.name}?")
//        builder.setMessage("Are you sure you want to delete ${args.currentRecipe.name}?")
//        builder.create().show()
//    }
}