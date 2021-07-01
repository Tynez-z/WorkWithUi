package com.example.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var mViewDataBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewDataBinding.lifecycleOwner = this
    }

    abstract fun getLayoutId(): Int

    fun getViewDataBinding(): T {
        return mViewDataBinding
    }

    fun getNavController(): NavController {
        return navController
    }
}


//    private fun hideBottomNav() {
//        this.bottomNavigationView.visibility = View.INVISIBLE
//    }
//
//    private fun showBottomNav() {
//        this.bottomNavigationView.visibility = View.VISIBLE
//    }

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
//        val navController = navHostFragment.navController

//        getNavController().addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.secondFragment -> hideBottomNav()
//                R.id.baanFragment -> hideBottomNav()
//                else -> showBottomNav()
//            }
//        }
