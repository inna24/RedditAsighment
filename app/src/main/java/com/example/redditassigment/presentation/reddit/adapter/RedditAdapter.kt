package com.example.redditassigment.presentation.reddit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import com.example.reddit.presentation.reddit.adapter.RedditViewHolder
import com.example.reddit.presentation.reddit.paging.RedditDiffUtilCallBack
import com.example.redditassigment.R
import com.example.redditassigment.data.database.entity.SubredditEntity
import com.example.redditassigment.databinding.ItemRvSubredditBinding


class RedditAdapter(private val onClick: (SubredditEntity) -> Unit) :
    PagedListAdapter<SubredditEntity, RedditViewHolder>(RedditDiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditViewHolder {
        DataBindingUtil.inflate<ItemRvSubredditBinding>(LayoutInflater.from(parent.context), R.layout.item_rv_subreddit, parent, false).let {
            return RedditViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
        getItem(position)?.let {subreddit ->
            holder.itemView.setOnClickListener { onClick.invoke(subreddit) }
            holder.bind(subreddit)
        }
    }
}