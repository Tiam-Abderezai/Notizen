package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notizen.R
import com.example.notizen.databinding.FragmentDetailBinding
import com.example.notizen.databinding.FragmentLoginBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val TAG = "DetailFragment"

    //    private val viewModel: RecipeViewModel by viewModels {
//        RecipeViewModel.Factory(RecipeRepository(requireActivity().application))
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        binding.apply {
            btnEdit.setOnClickListener {
                findNavController().navigate(R.id.action_detailFragment_to_editFragment)
            }
        }
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }
}


