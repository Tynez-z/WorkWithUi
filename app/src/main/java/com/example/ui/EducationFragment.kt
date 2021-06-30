package com.example.ui

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.toolbar_settings.*

//class EducationFragment : BaseFragment<FragmentEducationBinding>() {

class EducationFragment : BottomSheetFragment() {

    override val layoutId: Int = R.layout.fragment_education

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back.setOnClickListener {
            getNavController().navigate(R.id.action_educationFragment_to_firstFragment)
        }
    }
}