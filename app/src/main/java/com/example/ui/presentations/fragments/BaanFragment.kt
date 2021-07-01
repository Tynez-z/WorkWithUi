package com.example.ui.presentations.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.ui.R
import com.example.ui.databinding.FragmentBaanBinding
import com.example.ui.presentations.activities.MainActivity
import com.example.ui.presentations.base.BaseFragment
import kotlinx.android.synthetic.main.toolbar_base.*
import kotlinx.android.synthetic.main.toolbar_settings.ivBackBaseTb

class BaanFragment : BaseFragment<FragmentBaanBinding>() {

    override val layoutId: Int = R.layout.fragment_baan
    override var bottomNavigationViewVisibility = View.VISIBLE

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().apply {
            //TODO use single fun with binding!!
            ivBackBaseTb.setOnClickListener {
                getNavController().navigate(R.id.action_baanFragment_to_firstFragment)
            }

            //TODO use single fun with binding!!
            ivCancelBaseTb.setOnClickListener {
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        }
    }
}