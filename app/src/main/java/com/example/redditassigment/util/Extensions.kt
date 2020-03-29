package com.example.redditassigment.util

import android.app.Activity
import android.text.format.DateUtils
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.example.redditassigment.R
import java.util.*

fun Double.convertTime(): String {
    val timestamp = this.toLong()
    return DateUtils.getRelativeTimeSpanString(
        timestamp * 1000,
        System.currentTimeMillis(),
        DateUtils.MINUTE_IN_MILLIS
    ).toString().toLowerCase(Locale.getDefault())
}

fun Activity.createCustomTabs(): CustomTabsIntent {
    return CustomTabsIntent.Builder()
        .apply {
            setToolbarColor(ContextCompat.getColor(this@createCustomTabs, R.color.primary_dark))
            addDefaultShareMenuItem()
        }
        .build()
}