package com.example.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ui.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.toolbar_profile.*

class FirstFragment : Fragment(R.layout.fragment_first) {

    lateinit var fragmentFirstBinding: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentFirstBinding = FragmentFirstBinding.bind(view)

        settings.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
}