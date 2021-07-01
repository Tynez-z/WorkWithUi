package com.example.ui.presentations.fragments

import android.os.Bundle
import android.view.View
import com.example.ui.presentations.base.BaseFragment
import com.example.ui.R
import com.example.ui.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.toolbar_profile.*

class FirstFragment : BaseFragment<FragmentFirstBinding>() {

    override val layoutId: Int = R.layout.fragment_first

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().apply {
            ivSettings.setOnClickListener {
                getNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            }
        }
    }
}