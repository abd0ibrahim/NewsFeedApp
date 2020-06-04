package com.chethan.demoproject.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chethan.demoproject.R
import kotlinx.android.synthetic.main.drawer_fragment.*


class DrawerFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val listItems : Array<Triple<String, Int, Boolean>> = arrayOf(
        Triple("Explore", R.drawable.explore, true),
        Triple("Live Chat", R.drawable.live, false),
        Triple("Gallery", R.drawable.gallery, false),
        Triple("Wish List", R.drawable.wishlist, false),
        Triple("E-Magazine", R.drawable.emagazine, false)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.drawer_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewManager = LinearLayoutManager(activity)
        viewAdapter = DrawerListAdapter(listItems, context)

        recyclerView = drawer_recycler_view.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}