package com.example.workwithui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.toolbar_settings.*

class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var header: List<String>
    private lateinit var body: HashMap<String, List<String>>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stepBar.BarBuilder()
            .build()
            .init()
        showList()

        val listViewAdapter = ExpandableListAdapter(requireContext(), header, body)
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

        val body2: List<String> = listOf()
        val body3: List<String> = listOf()
        val body4: List<String> = listOf()
        val body5: List<String> = listOf()
        val body6: List<String> = listOf()
        val body7: List<String> = listOf()
        val body8: List<String> = listOf()
        val body9: List<String> = listOf()

        body[header[0]] = body1
        body[header[1]] = body2
        body[header[2]] = body3
        body[header[3]] = body4
        body[header[4]] = body5
        body[header[5]] = body6
        body[header[6]] = body7
        body[header[7]] = body8
        body[header[8]] = body9
    }
}