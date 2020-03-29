package com.example.redditassigment.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.redditassigment.data.database.entity.SubredditEntity
import com.example.redditassigment.data.database.entity.TABLE_NAME_REDDIT

@Dao
interface RedditDao {

    @Query("SELECT * FROM $TABLE_NAME_REDDIT")
    fun getRedditPosts(): List<SubredditEntity>
}