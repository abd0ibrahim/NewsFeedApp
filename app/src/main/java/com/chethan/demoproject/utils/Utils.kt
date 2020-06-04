package com.chethan.demoproject.utils

import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object {
        fun getFormattedDate(publishedAt: String): String? {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            val date =
                dateFormat.parse(publishedAt)
            val formatter =
                SimpleDateFormat("MMM dd, yyyy")
            return formatter.format(date)
        }
    }
}