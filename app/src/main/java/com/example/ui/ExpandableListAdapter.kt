package com.example.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import kotlinx.android.synthetic.main.layout_group.view.*

class ExpandableListAdapter(
        private var context: Context,
        private var header: List<String>,
        private var body: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {

    override fun getGroupCount() = header.size

    override fun getChildrenCount(groupPosition: Int) = body[header[groupPosition]]!!.size

    override fun getGroup(groupPosition: Int) = header[groupPosition]

    override fun getChild(groupPosition: Int, childPosition: Int) =
            body[header[groupPosition]]!![childPosition]

    override fun getGroupId(groupPosition: Int) = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int) = childPosition.toLong()

    override fun hasStableIds() = false

    override fun getGroupView(
            groupPosition: Int,
            isExpanded: Boolean,
            convertView: View?,
            parent: ViewGroup?
    ): View {

        var mConvertView = convertView
        val headerTitle = getGroup(groupPosition)

        if (mConvertView == null) {
            val inflater =
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            mConvertView = inflater.inflate(R.layout.layout_group, null)
        }

        val headerTv = mConvertView!!.tv_title
        headerTv.text = headerTitle
        return mConvertView
    }

    override fun getChildView(
            groupPosition: Int,
            childPosition: Int,
            isLastChild: Boolean,
            convertView: View?,
            parent: ViewGroup?): View {
        var mConvertView = convertView
        val bodyTitle = getChild(groupPosition, childPosition)
        if (mConvertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            mConvertView = inflater.inflate(R.layout.layout_child, null)
        }
        val bodyTv = mConvertView!!.tv_title
        bodyTv.text = bodyTitle
        return mConvertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int) = true
}