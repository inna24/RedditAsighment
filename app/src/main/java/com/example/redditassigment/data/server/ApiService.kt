package com.example.redditassigment.data.server


import com.example.redditassigment.data.server.pojo.response.Data
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

const val API_URL = "https://www.reddit.com/"

interface ApiService {

    @GET("r/funny/top.json?")
    fun getRedditList(@Query("limit") limit: Int): Single<Data>
}