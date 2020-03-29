package com.example.redditassigment.presentation.reddit

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.redditassigment.data.database.entity.SubredditEntity
import com.example.redditassigment.data.repository.RedditRepositoryImpl
import com.example.redditassigment.presentation.common.BaseViewModel
import com.example.redditassigment.presentation.reddit.paging.RedditDataSourceFactory
import java.util.concurrent.Executors


const val INITIAL_LIST_SIZE = 20
const val PAGE_LOAD_SIZE = 10

class RedditViewModel(private val redditRepository: RedditRepositoryImpl) : BaseViewModel() {

    fun getPagedListLiveData() : LiveData<PagedList<SubredditEntity>>{
        val sourceFactory = RedditDataSourceFactory(redditRepository, compositeDisposable, liveDataProgress, liveDataError)
       return LivePagedListBuilder<Int, SubredditEntity>(sourceFactory, createPagedListConfig())
           .setFetchExecutor(Executors.newSingleThreadExecutor())
           .build()
    }

    private fun createPagedListConfig() = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setInitialLoadSizeHint(INITIAL_LIST_SIZE)
        .setPageSize(PAGE_LOAD_SIZE)
        .build()
}