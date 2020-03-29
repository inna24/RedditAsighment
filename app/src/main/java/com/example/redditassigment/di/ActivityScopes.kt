package com.example.redditassigment.di

import com.example.redditassigment.data.database.entity.SubredditEntity
import com.example.redditassigment.presentation.reddit.RedditActivity
import com.example.redditassigment.presentation.reddit.RedditViewModel
import com.example.redditassigment.presentation.reddit.adapter.RedditAdapter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val redditScope = module {

    scope<RedditActivity> {
        viewModel { RedditViewModel(get()) }
        scoped { (onClick: (SubredditEntity) -> Unit) -> RedditAdapter(onClick) }
    }
}