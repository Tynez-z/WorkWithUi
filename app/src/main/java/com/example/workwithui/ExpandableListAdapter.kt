package com.example.workwithui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import kotlinx.android.synthetic.main.layout_group.view.*

class ExpandableListAdapter(
        var context: Context,
        var header: List<String>,
        var body: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return header.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
            return this.body[this.header[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): String {
        return header[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return this.body[this.header[groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
            groupPosition: Int,
            isExpanded: Boolean,
            convertView: View?,
            parent: ViewGroup?
    ): View {

        var mconvertView = convertView
        val headerTitle = getGroup(groupPosition) as String

        if (mconvertView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            mconvertView = inflater.inflate(R.layout.layout_group, null)
        }

        val headerTv = mconvertView!!.tv_title
        headerTv.text = headerTitle

        return mconvertView
    }

    override fun getChildView(
            groupPosition: Int,
            childPosition: Int,
            isLastChild: Boolean,
            convertView: View?,
            parent: ViewGroup?): View {
        var mconvertView = convertView
        val bodyTitle = getChild(groupPosition, childPosition) as String
        if (mconvertView == null) { val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            mconvertView = inflater.inflate(R.layout.layout_child, null)
        }

        val bodyTv = mconvertView!!.tv_title
        bodyTv.setText(bodyTitle)
        return mconvertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}