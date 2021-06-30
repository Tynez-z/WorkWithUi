package com.example.ui

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.toolbar_profile.*

class FirstFragment : BottomSheetFragment() {

    override val layoutId: Int = R.layout.fragment_first

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        getViewDataBinding().bottomNavigationView.setupWithNavController((getNavController()))

        settings.setOnClickListener {
            getNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
}