package com.example.redditassigment.data.repository

import com.example.redditassigment.data.server.NetworkSource
import com.example.reddit.presentation.reddit.paging.RedditPositionalDataSource.Companion.totalCount
import com.example.redditassigment.data.database.RedditDatabase
import com.example.redditassigment.data.database.entity.SubredditEntity
import com.example.redditassigment.presentation.reddit.INITIAL_LIST_SIZE
import com.example.redditassigment.util.applyIoSchedulers
import io.reactivex.Single


class RedditRepositoryImpl(private val networkSource: NetworkSource, val database: RedditDatabase) :
    RedditRepository {

    override fun getItemInitial(limit: Int): Single<List<SubredditEntity>> {
        return networkSource.getReddits(limit)
            .map { it.data.reddit.map { it.subredditData } }
            .onErrorResumeNext {
                totalCount = INITIAL_LIST_SIZE
                return@onErrorResumeNext Single.just(
                    database.redditDao().getRedditPosts().subList(
                        0,
                        INITIAL_LIST_SIZE
                    )
                )
            }
            .doOnSuccess { database.redditTransactionDao().insertNewPosts(it) }
            .applyIoSchedulers()
    }


    override fun getItemNext(limit: Int): Single<List<SubredditEntity>> {
        return networkSource.getReddits(limit)
            .map { it.data.reddit.map { it.subredditData } }
            .applyIoSchedulers()
    }

}
