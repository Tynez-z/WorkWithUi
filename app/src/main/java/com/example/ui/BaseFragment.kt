package com.example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    private lateinit var viewDataBinding: T
    abstract val layoutId: Int
    private lateinit var mRootView: View
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

//        getNavController().addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.secondFragment -> hideBottomNav()
//                else -> showBottomNav()
//            }
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        mRootView = viewDataBinding.root
        return mRootView
    }

    fun getViewDataBinding(): T {
        return viewDataBinding
    }

    fun getNavController(): NavController {
        return navController
    }

//    private fun hideBottomNav() {
//        requireActivity().bottomNavigationView?.visibility = View.INVISIBLE
//    }
//
//    private fun showBottomNav() {
//        requireActivity().bottomNavigationView?.visibility = View.VISIBLE
//    }
}



