package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notizen.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val TAG = "ProfileFragment"
    //    private val viewModel: RecipeViewModel by viewModels {
//        RecipeViewModel.Factory(RecipeRepository(requireActivity().application))
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
//        binding.addBtn.setOnClickListener {
//            insertDataToDatabase()
//        }
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }
}
