package com.example.redditassigment.presentation.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.jetbrains.anko.toast

abstract class BaseActivity<out V : BaseViewModel>() : AppCompatActivity() {

    protected abstract val layoutId: Int

    abstract val viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        observeLiveDataProgress()
        observeLiveDataError()
    }

    private fun observeLiveDataProgress(){
        viewModel.getLiveDataProgress().observe(this, Observer {
            showProgress(it)
        })
    }

    private fun observeLiveDataError(){
        viewModel.getLiveDataError().observe(this, Observer {
            showError(it)
        })
    }

    abstract fun showProgress(isProgress: Boolean)

    open fun showError(errorMessage: String){
        toast(errorMessage)
    }

}