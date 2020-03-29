package com.example.redditassigment.data.server


class NetworkSource(private val apiService: ApiService) {

    fun getReddits(limit: Int) = apiService.getRedditList(limit)

}