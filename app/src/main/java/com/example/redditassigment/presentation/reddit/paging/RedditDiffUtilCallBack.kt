package com.example.reddit.presentation.reddit.paging

import androidx.recyclerview.widget.DiffUtil
import com.example.redditassigment.data.database.entity.SubredditEntity

class RedditDiffUtilCallBack() : DiffUtil.ItemCallback<SubredditEntity>() {

    override fun areItemsTheSame(oldItem: SubredditEntity, newItem: SubredditEntity): Boolean {
        return oldItem.key == newItem.key
    }

    override fun areContentsTheSame(oldItem: SubredditEntity, newItem: SubredditEntity): Boolean {
        return oldItem.title == newItem.title &&
                oldItem.author == newItem.author &&
                oldItem.subreddit == newItem.subreddit &&
                oldItem.dateCreation == newItem.dateCreation
    }
}