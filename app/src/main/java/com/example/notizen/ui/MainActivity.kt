package com.example.notizen.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.notizen.R
import com.example.notizen.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
//            navController = Navigation.findNavController(navHostFragment)
//            setupActionBarWithNavController(navController)
            bottomNavigation.setOnItemReselectedListener { item ->
                when (item.itemId) {
                    R.id.item_home -> {
//                findNavController().navigate(R.id.action_addFragment_to_listFragment)
                    }
                    R.id.item_profile -> {
//                        Navigation.findNavController(navHostFragment)
//                            .navigate(R.id.action_listFragment_to_profileFragment)
                        Toast.makeText(applicationContext, "CLICKED", Toast.LENGTH_SHORT).show()
                        // Respond to navigation item 2 reselection
                    }
                }
//        setupSmoothBottomMenu()
            }
        }
    }


//
//    NavigationBarView.OnItemSelectedListener { item ->
//        when(item.itemId) {
//            R.id.item1 -> {
//                 Respond to navigation item 1 click
//                true
//            }
//            R.id.item2 -> {
//                 Respond to navigation item 2 click
//                true
//            }
//            else -> false
//        }
}