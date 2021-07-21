package com.example.ui.presentations.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.ui.R
import com.example.ui.databinding.ActivitySingleBinding
import com.example.ui.utill.makeGone
import com.example.ui.utill.makeVisible
import kotlinx.android.synthetic.main.fragment_base.*

class SingleActivity : AppCompatActivity() {

    private lateinit var singleActivityBinding: ActivitySingleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        singleActivityBinding = DataBindingUtil.setContentView(this@SingleActivity, R.layout.activity_single)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        singleActivityBinding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.medicalRecordsFragment -> {
                    hideBottomNavMenu()
                }
                else -> {
                    showBottomNavMenu()
                }
            }
        }
    }

    private fun hideBottomNavMenu() {
        singleActivityBinding.bottomNavigationView.makeGone()
    }

    private fun showBottomNavMenu() {
        singleActivityBinding.bottomNavigationView.makeVisible()
    }
}