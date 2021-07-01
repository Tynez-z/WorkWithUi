package com.example.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.ui.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.toolbar_settings.*

class SecondFragment : BaseFragment<FragmentSecondBinding>() {

    override val layoutId: Int = R.layout.fragment_second
    override var bottomNavigationViewVisibility = View.GONE

    private lateinit var header: List<String>
    private lateinit var body: HashMap<String, List<String>>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        stepBar.BarBuilder()
                .build()
                .init()
        showList()

        val listViewAdapter = ExpandableListAdapter(requireContext(), header, body)
        expListView.setAdapter(listViewAdapter)

        showExpandableList()

        getViewDataBinding().apply {
            ivBackBaseTb.setOnClickListener {
                getNavController().navigate(R.id.action_secondFragment_to_firstFragment)
            }
        }

        getViewDataBinding().apply {
            ivCancelSettingsTb.setOnClickListener {
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        }
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

    private fun showExpandableList () {
        getViewDataBinding().apply {
            btnYes.setOnClickListener {
                expListView.makeVisible()
                tvUpload.makeVisible()
                isClick = true
            }

            btnNo.setOnClickListener {
                expListView.makeInvisible()
                tvUpload.makeInvisible()
                isClick = false
            }
        }
    }
}