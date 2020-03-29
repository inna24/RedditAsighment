package com.example.redditassigment.data.repository

import com.example.redditassigment.data.database.entity.SubredditEntity
import io.reactivex.Single

interface RedditRepository {

    fun getItemInitial(limit: Int): Single<List<SubredditEntity>>

    fun getItemNext(limit: Int): Single<List<SubredditEntity>>
}