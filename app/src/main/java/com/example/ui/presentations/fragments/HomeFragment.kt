package com.example.ui.presentations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ui.BR
import com.example.ui.R
import com.example.ui.databinding.FragmentHomeBinding
import com.example.ui.presentations.base.BaseFragment

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentHomeBinding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        fragmentHomeBinding.setVariable(BR.homeFragment, this)
        return fragmentHomeBinding.root
    }
}