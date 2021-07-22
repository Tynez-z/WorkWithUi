package com.example.ui.presentations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ui.BR
import com.example.ui.R
import com.example.ui.databinding.FragmentEducationBinding
import com.example.ui.presentations.base.BaseFragment

class EducationFragment : BaseFragment(R.layout.fragment_education) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val fragmentEducationBinding: FragmentEducationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_education, container, false)
        fragmentEducationBinding.setVariable(BR.educationFragment, this)
        return fragmentEducationBinding.root
    }
}