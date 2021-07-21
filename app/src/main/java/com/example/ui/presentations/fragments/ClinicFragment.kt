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

class ClinicFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_clinic
    private lateinit var fragmentClinicBinding: FragmentClinicBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentClinicBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        fragmentClinicBinding.setVariable(BR.clinicFragment, this)
        return fragmentClinicBinding.root
    }
}