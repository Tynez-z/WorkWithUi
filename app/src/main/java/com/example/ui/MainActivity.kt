package com.example.ui

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.ui.databinding.ActivityMainBinding

//TODO dd close icon - close fragment to activity and make baseActivity
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        getViewDataBinding().bottomNavigationView.setupWithNavController((navController))


//        getNavController().addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.secondFragment -> hideBottomNav()
//                else -> showBottomNav()
//            }
//        }
    }

    override fun getLayoutId(): Int = R.layout.activity_main

//    private fun hideBottomNav() {
//        getViewDataBinding().bottomNavigationView.visibility = View.GONE
//    }
//
//    private fun showBottomNav () {
//        getViewDataBinding().bottomNavigationView.visibility = View.VISIBLE
}
