package com.example.ui.presentations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ui.BR
import com.example.ui.R
import com.example.ui.databinding.FragmentClinicBinding
import com.example.ui.presentations.base.BaseFragment

class ClinicFragment : BaseFragment(R.layout.fragment_clinic) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentClinicBinding: FragmentClinicBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_clinic, container, false)
        fragmentClinicBinding.setVariable(BR.clinicFragment, this)
        return fragmentClinicBinding.root
    }
}