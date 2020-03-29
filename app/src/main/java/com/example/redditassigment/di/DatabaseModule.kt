package com.example.redditassigment.di

import android.content.Context
import androidx.room.Room
import com.example.redditassigment.data.database.DB_NAME
import com.example.redditassigment.data.database.RedditDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule: Module = module {
    single { provideDatabase(androidApplication().applicationContext) }
}

private fun provideDatabase(context: Context) = Room.databaseBuilder(context, RedditDatabase::class.java, DB_NAME)
    .fallbackToDestructiveMigration()
    .build()