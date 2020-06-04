package com.chethan.demoproject.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.chethan.demoproject.R
import kotlinx.android.synthetic.main.drawer_list_item.view.*

class DrawerListAdapter(
    private var myDataset: Array<Triple<String, Int, Boolean>>,
    val context: Context?
) :
    RecyclerView.Adapter<DrawerListAdapter.UserViewHolder>() {

    companion object selectedItem;

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.drawer_list_item, parent, false)
    )

    override fun getItemCount() = myDataset.size
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(myDataset[position])
        
        if(myDataset[position].third){
            holder.itemView.selected_indicator.visibility = VISIBLE
        } else {
            holder.itemView.selected_indicator.visibility = INVISIBLE
        }
        
        holder.itemView.setOnClickListener{

            Toast.makeText(context, myDataset[position].first, Toast.LENGTH_SHORT).show()

            for((i , item) in myDataset.withIndex()){
                myDataset[i] = Triple(item.first, item.second, false)
            }

            myDataset[position] = Triple(myDataset[position].first, myDataset[position].second, true)

            notifyDataSetChanged()

        }
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemIcon = view.item_icon as ImageView
        private val itemText = view.item_text
        private val itemIndicator = view.selected_indicator
        fun bind(item: Triple<String, Int, Boolean>) {
            itemText.text = item.first
            itemIcon.setImageResource(item.second)
        }
    }
}

