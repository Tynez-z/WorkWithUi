package com.example.ui.presentations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui.presentations.base.BaseFragment
import com.example.ui.R
import com.example.ui.databinding.FragmentBottomSheetBinding

abstract class BottomSheetFragment : BaseFragment<FragmentBottomSheetBinding>() {

    override val layoutId: Int = R.layout.fragment_bottom_sheet

    //TODO check for use
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    //TODO remove
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        getViewDataBinding().bottomNavigationView.setupWithNavController((getNavController()))
    }
}