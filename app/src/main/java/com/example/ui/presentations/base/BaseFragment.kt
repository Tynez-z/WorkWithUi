package com.example.ui.presentations.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.ui.R
import com.example.ui.presentations.activities.SingleActivity
import com.example.ui.utill.makeGone
import com.example.ui.utill.makeVisible
import kotlinx.android.synthetic.main.fragment_base_toolbar.*

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        showTvTitle()
    }

    private fun showTvTitle() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.medicalRecordsFragment -> {
                    tvMedicalRecords?.makeVisible()
                    ivSettingsToolbar?.makeGone()
                }
                R.id.clinicFragment -> {
                    ivSettingsToolbar?.makeVisible()
                    tvMedicalRecords?.makeGone()
                    ivBackBaseToolbar?.makeGone()
                    ivCancelSettingsToolbar?.makeGone()
                }
                else -> {
                    ivBackBaseToolbar?.makeVisible()
                    ivSettingsToolbar?.makeGone()
                    tvMedicalRecords?.makeGone()
                }
            }
        }
    }

    private fun getNavController(): NavController {
        return navController
    }

    open fun onBackClick() {
       getNavController().navigateUp()
    }

    open fun onCancelClick() {
        val intent = Intent(requireContext(), SingleActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    open fun onClickSettings() {
        getNavController().navigate(R.id.action_clinicFragment_to_medicalRecordsFragment)
    }
}