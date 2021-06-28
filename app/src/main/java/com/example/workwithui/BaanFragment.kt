package com.example.workwithui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.workwithui.databinding.FragmentBaanBinding
import kotlinx.android.synthetic.main.toolbar_settings.*


class BaanFragment : Fragment(R.layout.fragment_baan) {

    lateinit var binding: FragmentBaanBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBaanBinding.bind(view)

        back.setOnClickListener {
            findNavController().navigate(R.id.action_baanFragment_to_firstFragment)
        }
    }
}