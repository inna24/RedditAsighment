package com.example.redditassigment.presentation.reddit.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.reddit.presentation.reddit.paging.RedditPositionalDataSource
import com.example.redditassigment.data.database.entity.SubredditEntity
import com.example.redditassigment.data.repository.RedditRepositoryImpl
import io.reactivex.disposables.CompositeDisposable

class RedditDataSourceFactory(private val repositoryImpl: RedditRepositoryImpl,
                              private val disposable: CompositeDisposable,
                              private val liveDataProgress: MutableLiveData<Boolean>,
                              private val liveDataError: MutableLiveData<String>
) : DataSource.Factory<Int, SubredditEntity>() {

    override fun create(): DataSource<Int, SubredditEntity> {
       return  RedditPositionalDataSource(repositoryImpl, disposable, liveDataProgress, liveDataError)
    }
}