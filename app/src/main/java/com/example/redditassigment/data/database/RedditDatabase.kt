package com.example.redditassigment.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.redditassigment.data.database.dao.RedditDao
import com.example.reddit.data.database.dao.RedditTransactionDao
import com.example.redditassigment.data.database.entity.SubredditEntity


const val DB_NAME = "reddit_database"

@Database(
    entities = arrayOf(SubredditEntity::class),
    version = 1,
    exportSchema = false
)
abstract class RedditDatabase : RoomDatabase() {

    abstract fun redditDao(): RedditDao

    abstract fun redditTransactionDao(): RedditTransactionDao
}