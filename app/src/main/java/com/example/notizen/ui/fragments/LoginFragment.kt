package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.notizen.R
//import com.example.notizen.data.model.Recipe
//import com.example.notizen.data.repo.RecipeRepository
import com.example.notizen.databinding.FragmentLoginBinding
//import com.example.notizen.utils.Globals
//import com.example.notizen.utils.Globals.Companion.TAG_FRAG_ADD
//import com.example.notizen.utils.Logger
//import com.example.notizen.viewmodel.RecipeViewModel
//import kotlinx.android.synthetic.main.fragment_add.*


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val TAG = "LoginFragment"
//    private val viewModel: RecipeViewModel by viewModels {
//        RecipeViewModel.Factory(RecipeRepository(requireActivity().application))
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.apply {
            btnLogin.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_listFragment)
            }
            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
        Log.d(TAG, "onCreateView: ")
//        Logger.logd(TAG_FRAG_ADD, "onCreateView")

        return binding.root
    }

}