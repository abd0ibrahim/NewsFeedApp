package com.chethan.demoproject.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chethan.demoproject.R
import com.chethan.demoproject.model.Article
import kotlinx.android.synthetic.main.news_list_item.view.*
import java.text.SimpleDateFormat
import java.util.*


class NewsListAdapter(private val context: Context, private val articlesList: List<Article>) :
    RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {
    private var onItemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.news_list_item, viewGroup, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.apply {
            title.text = articlesList[position].title
            auth.text = "By ${articlesList[position].author}"
            desc.text = articlesList[position].description
            date.text = getFormattedDate(articlesList[position].publishedAt)
        }

        Glide.with(viewHolder.itemView.context)
            .load(articlesList[position].urlToImage)
            .into(viewHolder.image)

        viewHolder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(viewHolder.itemView, position)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.news_item_title as TextView
        val auth = itemView.news_item_auth as TextView
        val desc = itemView.news_item_desc as TextView
        val date = itemView.news_item_date as TextView
        val image = itemView.news_item_image as ImageView
    }


    fun setItemClickListener(clickListener: ItemClickListener) {
        onItemClickListener = clickListener
    }

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    private fun getFormattedDate(publishedAt: String): String? {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val date =
            dateFormat.parse(publishedAt)
        val formatter =
            SimpleDateFormat("MMM dd, yyyy")
        return formatter.format(date)
    }

}