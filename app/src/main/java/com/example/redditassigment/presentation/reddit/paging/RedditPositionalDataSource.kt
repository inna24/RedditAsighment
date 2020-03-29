package com.example.reddit.presentation.reddit.paging

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PositionalDataSource
import com.example.redditassigment.R
import com.example.redditassigment.RedditAssignmentApplication
import com.example.redditassigment.data.repository.RedditRepositoryImpl
import com.example.redditassigment.data.database.entity.SubredditEntity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import org.jetbrains.anko.getStackTraceString

class RedditPositionalDataSource(
    private val repositoryImpl: RedditRepositoryImpl,
    private val disposable: CompositeDisposable,
    private val liveDataProgress: MutableLiveData<Boolean>,
    private val liveDataError: MutableLiveData<String>
) : PositionalDataSource<SubredditEntity>() {

    companion object {
        var totalCount: Int = 50
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<SubredditEntity>) {
        repositoryImpl.getItemInitial(params.requestedLoadSize)
            .doOnSubscribe { liveDataProgress.postValue(true) }
            .doAfterTerminate { liveDataProgress.postValue(false) }
            .subscribeBy(onSuccess = {
                if (params.placeholdersEnabled && it.isNotEmpty()) {
                    val position = computeInitialLoadPosition(params, totalCount)
                    callback.onResult(it, position, totalCount)
                } else liveDataError.postValue(RedditAssignmentApplication.instance.getString(R.string.txt_epty_message))
            }, onError = {
                liveDataError.postValue(it.message)
            }).apply { disposable.addAll(this) }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<SubredditEntity>) {
        repositoryImpl.getItemNext(params.startPosition + params.loadSize)
            .subscribeBy(onSuccess = {
            val result = it.subList(params.startPosition, params.startPosition + params.loadSize)
            callback.onResult(result)
        }, onError = {
            Log.e(RedditPositionalDataSource::class.java.simpleName, it.getStackTraceString())
        }).apply { disposable.add(this) }

    }
}