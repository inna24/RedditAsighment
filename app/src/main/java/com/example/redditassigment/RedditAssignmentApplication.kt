package com.example.redditassigment

import android.app.Application
import com.example.redditassigment.di.databaseModule
import com.example.redditassigment.di.networkModule
import com.example.redditassigment.di.redditScope
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RedditAssignmentApplication : Application() {

    companion object {
        lateinit var instance: RedditAssignmentApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin{
            // Use Koin Android Logger
            androidLogger()
            // declare Android context
            androidContext(this@RedditAssignmentApplication)
            // declare modules to use
            modules(databaseModule, networkModule, redditScope)
        }
    }

}