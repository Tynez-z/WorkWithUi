package com.example.ui.presentations.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.ui.R
import com.example.ui.databinding.FragmentBaseBinding
import com.example.ui.presentations.activities.SingleActivity
import com.example.ui.utill.makeGone
import com.example.ui.utill.makeVisible
import kotlinx.android.synthetic.main.fragment_base.*
import kotlinx.android.synthetic.main.toolbar_profile.*

abstract class BaseFragment : Fragment() {

    abstract val layoutId: Int
    private lateinit var navController: NavController
    private lateinit var baseBinding: FragmentBaseBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        baseBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_base, container, false)
        return baseBinding.root
    }

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
                }
                else -> {
                    tvMedicalRecords?.makeGone()
                }
            }
        }
    }

    private fun getNavController(): NavController {
        return navController
    }

    open fun onBackClick() {
        ivBackBaseToolbar.setOnClickListener {
            getNavController().navigateUp()
        }
    }

    open fun onCancelClick() {
        ivCancelSettingsToolbar.setOnClickListener {
            val intent = Intent(requireContext(), SingleActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }

    open fun onClickSettings() {
        ivSettingsToolbar.setOnClickListener {
            getNavController().navigate(R.id.action_clinicFragment_to_medicalRecordsFragment)
        }
    }
}