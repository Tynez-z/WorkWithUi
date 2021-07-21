package com.example.ui.presentations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ui.BR
import com.example.ui.R
import com.example.ui.adapters.ExpandableListAdapter
import com.example.ui.databinding.FragmentMedicalRecordsBinding
import com.example.ui.presentations.base.BaseFragment
import com.example.ui.utill.*
import kotlinx.android.synthetic.main.fragment_medical_records.*

//TODO work with layoutId and binding
class MedicalRecordsFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_medical_records

    private lateinit var header: List<String>
    private lateinit var body: HashMap<String, List<String>>
    private lateinit var medicalRecordsBinding: FragmentMedicalRecordsBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        medicalRecordsBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        medicalRecordsBinding.setVariable(BR.medicalRecordsFragment, this)
        return medicalRecordsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showList()
        setCustomView()

        //TODO use single fun for init adapter
        val listViewAdapter = ExpandableListAdapter(requireContext(), header, body)
        expListView.setAdapter(listViewAdapter)

        showExpandableList() //TODO remove
    }

    //use custom data in this fun - mapping data
    //TODO rename (initData...)
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

    private fun setCustomView() {
        stepBar.BarBuilder()
                .build()
                .init()
    }

    //TODO use data binding xml
    private fun showExpandableList() {
        medicalRecordsBinding.apply {
            btnNoMedicalRecords.setOnClickListener {
                expListView.makeInvisible()
                tvUploadMedicalRecords.makeInvisible()
                isClickNo = true
                isClickYes = false
            }
        }
    }

    //EXAMPLE
    fun clickOnYesButton(){
        medicalRecordsBinding.apply {
            expListView.makeVisible()
            tvUploadMedicalRecords.makeVisible()
            isClickYes = true
            isClickNo = false
        }
    }
}