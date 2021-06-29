package com.example.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ui.databinding.FragmentEducationBinding
import kotlinx.android.synthetic.main.toolbar_settings.*

//TODO use base fragment with constructor (layout) and onViewCreated
class EducationFragment : Fragment(R.layout.fragment_education) {

    lateinit var fragmentEducationBinding: FragmentEducationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentEducationBinding = FragmentEducationBinding.bind(view)
        back.setOnClickListener {
            findNavController().navigate(R.id.action_educationFragment_to_firstFragment)
        }
    }
}