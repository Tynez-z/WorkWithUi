package com.example.workwithui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.workwithui.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.toolbar_profile.*
// TODO: rename binding to as fragment name + binding
class FirstFragment : Fragment(R.layout.fragment_first) {

    lateinit var binding: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        settings.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
}