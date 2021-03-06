package com.example.android.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: WelcomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_fragment,
            container,
            false
        )
        binding.goToInstructionsButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_instructionsFragment)
        }
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        binding.welcomeText.text =
            resources.getString(R.string.welcome) + arguments?.getString("login") + resources.getString(
                R.string.mark
            )
        return binding.root
    }
}