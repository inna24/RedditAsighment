package com.example.redditassigment.util

import android.view.View

fun View.visible() { visibility = View.VISIBLE }

fun View.visibility(condition: Boolean) {
    visibility = if (condition) View.VISIBLE else View.GONE
}