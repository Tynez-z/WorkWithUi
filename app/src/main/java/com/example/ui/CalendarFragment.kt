package com.example.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ui.databinding.FragmentCalendarBinding
import kotlinx.android.synthetic.main.toolbar_settings.*

//class CalendarFragment : BaseFragment<FragmentCalendarBinding>() {

    class CalendarFragment : BottomSheetFragment() {

        override val layoutId: Int = R.layout.fragment_calendar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back.setOnClickListener {
            getNavController().navigate(R.id.action_calendarFragment_to_firstFragment)
        }
    }
}