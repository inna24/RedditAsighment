package com.example.redditassigment.presentation.reddit.bindings

import androidx.databinding.BindingConversion
import com.example.redditassigment.util.convertTime

object BindingsConverter {

    @BindingConversion
    @JvmStatic
    fun convertDate(date: Double) = date.convertTime()

    @BindingConversion
    @JvmStatic
    fun convertLong(number:Long) = number.toString()
}