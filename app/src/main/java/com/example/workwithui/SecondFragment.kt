package com.example.workwithui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.workwithui.databinding.FragmentSecondBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var listViewAdapter: ExpandableListAdapter
    private lateinit var header: List<String>
    private lateinit var body: HashMap<String, List<String>>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stepBar.BarBuilder()
            .build()
            .init()

        showList()

        listViewAdapter = ExpandableListAdapter(requireContext(), header, body)
        expendableListView.setAdapter(listViewAdapter)

        back.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
    }

    private fun showList() {
        header = ArrayList()
        body = HashMap()

        (header as ArrayList<String>).add("CT Scan")
        (header as ArrayList<String>).add("X-Ray")
        (header as ArrayList<String>).add("Doctors letter")
        (header as ArrayList<String>).add("Lab test")
        (header as ArrayList<String>).add("Blood test")
        (header as ArrayList<String>).add("ECHO")
        (header as ArrayList<String>).add("EKG")
        (header as ArrayList<String>).add("Forms")
        (header as ArrayList<String>).add("Other")

        val body1: MutableList<String> = ArrayList()
        body1.add("PDF20201223.pdf")
        body1.add("PDF20201223.pdf")
        body[header[0]] = body1
        //TODO why this apk crash on this features! check it and refactor
    }


}