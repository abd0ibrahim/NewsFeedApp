package com.chethan.demoproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chethan.demoproject.model.Article
import com.chethan.demoproject.utils.Utils


class NewsDetailsFragment : Fragment() {

    lateinit var article: Article

    companion object {
        const val KEY_PRODUCT = "KEY_PRODUCT"

        fun newInstance(article: Article): NewsDetailsFragment {
            val args = Bundle()
            args.putSerializable(KEY_PRODUCT, article)
            val fragment = NewsDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            article = it.getSerializable(KEY_PRODUCT) as Article
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.findViewById<TextView>(R.id.news_item_details_title).text = article.title
        view.findViewById<TextView>(R.id.news_item_details_auth).text = "By ${article.author}"
        view.findViewById<TextView>(R.id.news_item_details_desc).text = article.description
        view.findViewById<TextView>(R.id.news_item_details_date).text =
            Utils.getFormattedDate(article.publishedAt)

        view.findViewById<Button>(R.id.open_website_button).setOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
            startActivity(browserIntent)
        }

        if (article.urlToImage.isNotEmpty()) {
            Glide.with(context)
                .load(article.urlToImage)
                .into(view.findViewById(R.id.news_item_details_image))
        } else {
            view.findViewById<ImageView>(R.id.news_item_details_image).setImageResource(R.drawable.news_place_holder_image)
        }

        super.onViewCreated(view, savedInstanceState)

    }
}