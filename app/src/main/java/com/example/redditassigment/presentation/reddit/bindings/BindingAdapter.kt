package com.example.redditassigment.presentation.reddit.bindings

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object BindingAdapter {

    @BindingAdapter("app:urlImage", "app:errorDrawable")
    @JvmStatic
    fun loadImage(imageView: AppCompatImageView, url: String, drawable: Drawable) {
        Glide.with(imageView.context).load(url)
            .apply(RequestOptions().placeholder(
                    drawable
                ).error(
                    drawable
                )
            )
            .into(imageView)
    }
}