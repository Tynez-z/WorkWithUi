package com.example.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.ui.setupWithNavController
import com.example.ui.databinding.FragmentBottomSheetBinding

abstract class BottomSheetFragment : BaseFragment<FragmentBottomSheetBinding>() {

    override val layoutId: Int = R.layout.fragment_bottom_sheet

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().bottomNavigationView.setupWithNavController((getNavController()))
    }
}