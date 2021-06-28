package com.example.workwithui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.workwithui.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.toolbar_profile.*
import kotlinx.android.synthetic.main.toolbar_settings.*

class HomeFragment : Fragment(R.layout.fragment_home) {
lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        back.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_firstFragment)
        }
    }
}