package com.example.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ui.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.toolbar_settings.*

class SecondFragment : Fragment(R.layout.fragment_second) {

    lateinit var secondFragmentBinding: FragmentSecondBinding
    private lateinit var header: List<String>
    private lateinit var body: HashMap<String, List<String>>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        secondFragmentBinding = FragmentSecondBinding.bind(view)

        stepBar.BarBuilder()
                .build()
                .init()
        showList()

        val listViewAdapter = ExpandableListAdapter(requireContext(), header, body)
        expendableListView.setAdapter(listViewAdapter)

        showExpandableList()

        back.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

        //TODO add work with close icon
    }

    private fun showList() {
        header = ArrayList()
        body = HashMap()

        (header as ArrayList<String>).add(CT_SCAN)
        (header as ArrayList<String>).add(X_RAY)
        (header as ArrayList<String>).add(DOCTORS_LETTER)
        (header as ArrayList<String>).add(LAB_TEST)
        (header as ArrayList<String>).add(BLOOD_TEST)
        (header as ArrayList<String>).add(ECHO)
        (header as ArrayList<String>).add(EKG)
        (header as ArrayList<String>).add(FORMS)
        (header as ArrayList<String>).add(OTHER)

        val bodyFiles: MutableList<String> = ArrayList()
        bodyFiles.add(PDF)
        bodyFiles.add(PDF)

        val bodyEmpty: List<String> = listOf()

        body[header[0]] = bodyFiles
        body[header[1]] = bodyEmpty
        body[header[2]] = bodyEmpty
        body[header[3]] = bodyEmpty
        body[header[4]] = bodyEmpty
        body[header[5]] = bodyEmpty
        body[header[6]] = bodyEmpty
        body[header[7]] = bodyEmpty
        body[header[8]] = bodyEmpty
    }

    //TODO make with binding in layout
    private fun showExpandableList () {
        secondFragmentBinding.apply {
            rb_yes.setOnClickListener {
                expendableListView.visibility = View.VISIBLE
                upload.visibility = View.VISIBLE
            }

            rb_no.setOnClickListener {
                expendableListView.visibility = View.INVISIBLE
                upload.visibility = View.INVISIBLE
            }
        }
    }
}