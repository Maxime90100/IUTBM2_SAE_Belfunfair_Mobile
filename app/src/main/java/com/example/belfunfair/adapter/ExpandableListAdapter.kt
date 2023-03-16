package com.example.belfunfair.adapter
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.belfunfair.R
import java.util.*
import kotlin.collections.ArrayList

class ExpandableListAdapter internal constructor(
    private val context: Context,
    private val titleList: List<String>,
    private val dataList: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {
    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return this.dataList[this.titleList[listPosition]]!![expandedListPosition]
    }
    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }
    override fun getChildView(
        listPosition: Int,
        expandedListPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var _convertView = convertView
        val expandedListText = getChild(listPosition, expandedListPosition) as String
        if (convertView == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            _convertView = layoutInflater.inflate(R.layout.list_item, null)
        }
        val expandedListTextView = _convertView!!.findViewById<TextView>(R.id.listView)
        expandedListTextView.text = expandedListText
        return _convertView
    }
    override fun getChildrenCount(listPosition: Int): Int {
        return this.dataList[this.titleList[listPosition]]!!.size
    }
    override fun getGroup(listPosition: Int): Any {
        return this.titleList[listPosition]
    }
    override fun getGroupCount(): Int {
        return this.titleList.size
    }
    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }
    override fun getGroupView(
        listPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var _convertView = convertView
        val listTitle = getGroup(listPosition) as String
        if (convertView == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            _convertView = layoutInflater.inflate(R.layout.list_item, null)
        }
        val listTitleTextView = _convertView!!.findViewById<TextView>(R.id.listView)
        listTitleTextView.setTypeface(null, Typeface.BOLD)
        listTitleTextView.setTextColor(ContextCompat.getColor(this.context, R.color.orange_dark))
        listTitleTextView.text = listTitle
        return _convertView
    }
    override fun hasStableIds(): Boolean {
        return false
    }
    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }

    fun setListeners(expandableListView: ExpandableListView, listData: HashMap<String, List<String>>) {
        expandableListView.setOnGroupExpandListener { groupPosition ->
            // Collapse all other groups except the one that was just expanded
            for (i in 0 until expandableListView.expandableListAdapter.groupCount) {
                if (i != groupPosition) {
                    expandableListView.collapseGroup(i)
                }
            }
            // Display a toast message with information about the expanded group
            val list = expandableListView.expandableListAdapter.getGroup(groupPosition)
            val numElements = expandableListView.expandableListAdapter.getChildrenCount(groupPosition)
            Toast.makeText(this.context, "$numElements $list", Toast.LENGTH_SHORT).show()
        }
        expandableListView.setOnGroupCollapseListener { groupPosition ->
            // Do nothing when a group is collapsed
        }
    }
}