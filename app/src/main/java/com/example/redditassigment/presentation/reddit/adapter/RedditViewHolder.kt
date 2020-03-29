package com.example.reddit.presentation.reddit.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.redditassigment.data.database.entity.SubredditEntity
import com.example.redditassigment.databinding.ItemRvSubredditBinding

class RedditViewHolder(val binding: ItemRvSubredditBinding) :RecyclerView.ViewHolder(binding.root) {

    fun bind(subreddit: SubredditEntity) {
        binding.subreddit = subreddit
        binding.executePendingBindings()
    }
}