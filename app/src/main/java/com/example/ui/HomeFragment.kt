package com.example.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ui.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.toolbar_settings.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHomeBinding = FragmentHomeBinding.bind(view)
        back.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_firstFragment)
        }
    }
}