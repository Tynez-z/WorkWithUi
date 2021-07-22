package com.example.ui.presentations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ui.BR
import com.example.ui.R
import com.example.ui.databinding.FragmentCalendarBinding
import com.example.ui.presentations.base.BaseFragment

class CalendarFragment : BaseFragment(R.layout.fragment_calendar) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentCalendarBinding: FragmentCalendarBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_calendar, container, false)
        fragmentCalendarBinding.setVariable(BR.calendarFragment, this)
        return fragmentCalendarBinding.root
    }
}