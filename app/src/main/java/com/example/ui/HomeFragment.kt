package com.example.ui

import android.os.Bundle
import android.view.View
import com.example.ui.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.toolbar_settings.*

//class HomeFragment : BaseFragment<FragmentHomeBinding>() {

class HomeFragment : BottomSheetFragment() {

    override val layoutId: Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back.setOnClickListener {
            getNavController().navigate(R.id.action_homeFragment_to_firstFragment)
        }
    }
}