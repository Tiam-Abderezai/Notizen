package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notizen.R
import com.example.notizen.databinding.FragmentComposeBinding

class ComposeFragment : Fragment() {
    private lateinit var binding: FragmentComposeBinding
    private val TAG = "ComposeFragment"

    //    private val viewModel: RecipeViewModel by viewModels {
//        RecipeViewModel.Factory(RecipeRepository(requireActivity().application))
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentComposeBinding.inflate(inflater, container, false)
        binding.apply {
            btnSave.setOnClickListener {
                findNavController().navigate(R.id.action_composeFragment_to_listFragment)
            }
        }
//        binding.addBtn.setOnClickListener {
//            insertDataToDatabase()
//        }
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }
}
