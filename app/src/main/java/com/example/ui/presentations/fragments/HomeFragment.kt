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

//TODO work with layoutId and binding
class HomeFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_home
    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        fragmentHomeBinding.setVariable(BR.homeFragment, this)
        return fragmentHomeBinding.root
    }
}