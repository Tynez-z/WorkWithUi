package com.example.workwithui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.workwithui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        activityMainBinding.bottomNavigationView.setupWithNavController((navController))

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.secondFragment -> hideBottomNav()
                else -> showBottomNav()
            }
        }
    }

    private fun hideBottomNav() {
        activityMainBinding.bottomNavigationView.visibility = View.GONE
    }

    private fun showBottomNav () {
        activityMainBinding.bottomNavigationView.visibility = View.VISIBLE
    }
}