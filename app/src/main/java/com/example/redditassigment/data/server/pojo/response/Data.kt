package com.example.redditassigment.data.server.pojo.response

import com.example.redditassigment.data.database.entity.SubredditEntity
import com.google.gson.annotations.SerializedName

class Data(@SerializedName("data") val data: Children)

class Children(@SerializedName("children") val reddit: List<Reddit>)

class Reddit(@SerializedName("data") val subredditData: SubredditEntity)