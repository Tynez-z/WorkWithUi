package com.example.ui.presentations.activities

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.ui.presentations.base.BaseActivity
import com.example.ui.R
import com.example.ui.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        getViewDataBinding().bottomNavigationView.setupWithNavController(navController)
    }

    fun setBottomNavigationVisibility(visibility: Int) {
        getViewDataBinding().bottomNavigationView.visibility = visibility
    }

    override fun getLayoutId(): Int = R.layout.activity_main
}