package com.example.ui

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.toolbar_settings.*

class BaanFragment : BottomSheetFragment() {

    override val layoutId: Int = R.layout.fragment_baan

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        back.setOnClickListener {
            getNavController().navigate(R.id.action_baanFragment_to_firstFragment)
        }
    }
}