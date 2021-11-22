package com.example.notizen.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notizen.R
import com.example.notizen.databinding.FragmentDetailBinding
import com.example.notizen.databinding.FragmentProfileBinding
import com.example.notizen.model.local.DataStore
import com.example.notizen.model.local.LocalRepo
import com.example.notizen.viewmodel.LocalViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    //    private val args by navArgs<ProfileFragmentArgs>()
    private lateinit var username: String
    private lateinit var email: String

    private val TAG = "ProfileFragment"
//    private val viewModel: LocalViewModel by viewModels {
//        LocalViewModel.Factory(LocalRepo(requireActivity().application))
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lifecycleScope.launch(Dispatchers.IO) {
            context?.let {
                username = DataStore(it).getUsername().toString()
                email = DataStore(it).getEmail().toString()
            }
        }

        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.apply {
            Log.d(TAG, "onCreateView: $username $email")
            tvUsername.text = username
            tvEmail.text = email
            btnSync.setOnClickListener {
                Log.d(TAG, "onCreateView: SYNC")
//                viewModel.deleteNote(args.note)
//                findNavController().navigate(R.id.listFragment)
            }
//            btnEdit.setOnClickListener {
//                val action = DetailFragmentDirections.actionDetailFragmentToEditFragment(args.note)
//                findNavController().navigate(action)
//            }
        }
        Log.d(TAG, "onCreateView: ")
        return binding.root
    }
}
