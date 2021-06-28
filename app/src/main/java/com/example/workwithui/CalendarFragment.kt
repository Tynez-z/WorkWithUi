package com.example.workwithui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.workwithui.databinding.FragmentBaanBinding
import com.example.workwithui.databinding.FragmentCalendarBinding
import kotlinx.android.synthetic.main.toolbar_profile.*
import kotlinx.android.synthetic.main.toolbar_settings.*

class CalendarFragment : Fragment(R.layout.fragment_calendar) {

    lateinit var binding: FragmentCalendarBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCalendarBinding.bind(view)
        back.setOnClickListener {
            findNavController().navigate(R.id.action_calendarFragment_to_firstFragment)
        }
    }
}
