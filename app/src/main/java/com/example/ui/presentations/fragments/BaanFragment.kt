package com.example.ui.presentations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ui.BR
import com.example.ui.R
import com.example.ui.databinding.FragmentBaanBinding
import com.example.ui.presentations.base.BaseFragment

class BaanFragment : BaseFragment(R.layout.fragment_baan) {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentBaanBinding : FragmentBaanBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_baan, container, false)
        fragmentBaanBinding.setVariable(BR.baanFragment, this)
        return fragmentBaanBinding.root
    }
}