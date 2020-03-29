package com.example.reddit.data.database.dao

import androidx.room.*
import com.example.redditassigment.data.database.entity.SubredditEntity

@Dao
abstract class RedditTransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPosts(posts: List<SubredditEntity>)

    @Query("DELETE FROM subreddit")
    abstract fun clearOldPosts()

    @Transaction
    open fun insertNewPosts(posts: List<SubredditEntity>){
        clearOldPosts()
        insertPosts(posts)
    }
}