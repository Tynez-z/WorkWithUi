package com.example.workwithui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    private lateinit var listViewAdapter: ExpandableListAdapter
    private lateinit var header: List<String>
    private lateinit var body: HashMap<String, List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        showList()
        listViewAdapter = ExpandableListAdapter(this, header, body)
        expendableListView.setAdapter(listViewAdapter)
        back.setOnClickListener {
            val intent = Intent(applicationContext, FirstFragment::class.java)
            startActivity(intent)
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
    }
}