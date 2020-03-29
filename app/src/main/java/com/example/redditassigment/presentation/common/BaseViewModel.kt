package com.example.redditassigment.presentation.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel(){

    protected val compositeDisposable = CompositeDisposable()

    protected val liveDataProgress = MutableLiveData<Boolean>()

    protected val liveDataError = MutableLiveData<String>()

    protected fun addDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    fun getLiveDataProgress(): LiveData<Boolean> = liveDataProgress

    fun getLiveDataError(): LiveData<String> = liveDataError

    override fun onCleared() {
        if(!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }
}