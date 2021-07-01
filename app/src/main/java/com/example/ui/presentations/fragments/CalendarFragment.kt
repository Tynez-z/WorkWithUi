package com.example.ui.presentations.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.ui.presentations.base.BaseFragment
import com.example.ui.R
import com.example.ui.databinding.FragmentCalendarBinding
import com.example.ui.presentations.activities.MainActivity
import kotlinx.android.synthetic.main.toolbar_base.*
import kotlinx.android.synthetic.main.toolbar_settings.ivBackBaseTb

class CalendarFragment : BaseFragment<FragmentCalendarBinding>() {

    override val layoutId: Int = R.layout.fragment_calendar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().apply {
            ivBackBaseTb.setOnClickListener {
                getNavController().navigate(R.id.action_calendarFragment_to_firstFragment)
            }
        }

        getViewDataBinding().apply {
            ivCancelBaseTb.setOnClickListener {
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        }
    }
}