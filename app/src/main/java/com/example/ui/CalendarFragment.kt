package com.example.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ui.databinding.FragmentCalendarBinding
import kotlinx.android.synthetic.main.toolbar_settings.*

class CalendarFragment : Fragment(R.layout.fragment_calendar) {

    //TODO use inside fun
    lateinit var fragmentCalendarBinding: FragmentCalendarBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentCalendarBinding = FragmentCalendarBinding.bind(view)
        back.setOnClickListener {
            findNavController().navigate(R.id.action_calendarFragment_to_firstFragment)
        }
    }
}