package com.example.ui.presentations.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.ui.R
import com.example.ui.databinding.FragmentEducationBinding
import com.example.ui.presentations.activities.MainActivity
import com.example.ui.presentations.base.BaseFragment
import kotlinx.android.synthetic.main.toolbar_base.*
import kotlinx.android.synthetic.main.toolbar_settings.ivBackBaseTb

class EducationFragment : BaseFragment<FragmentEducationBinding>() {

    override val layoutId: Int = R.layout.fragment_education

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO use single fun with binding!!
        getViewDataBinding().apply {
            ivBackBaseTb.setOnClickListener {
                getNavController().navigate(R.id.action_educationFragment_to_firstFragment)
            }
        }

        //TODO use single fun with binding!!
        ivCancelBaseTb.setOnClickListener {
            //TODO use single fun from utils for all fragments (CommonUtils)
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
    }
}