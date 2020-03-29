package com.example.redditassigment.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val TABLE_NAME_REDDIT = "subreddit"

@Entity(tableName = TABLE_NAME_REDDIT)
data class SubredditEntity(
    @PrimaryKey
    val title: String,
    @SerializedName("name") val key: String,
    @SerializedName("subreddit") val subreddit: String,
    @SerializedName("author") val author: String,
    @SerializedName("score") val score: Long,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("url") val url: String,
    @SerializedName("created_utc") val dateCreation: Double,
    @SerializedName("num_comments") val numComments: Long
)