package com.example.redditassigment.di

import com.example.redditassigment.BuildConfig
import com.example.redditassigment.data.repository.RedditRepositoryImpl
import com.example.redditassigment.data.server.API_URL
import com.example.redditassigment.data.server.ApiService
import com.example.redditassigment.data.server.NetworkSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule: Module = module {

    single { NetworkSource(get()) }
    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }
    single { RedditRepositoryImpl(get(), get()) }

    single {
        Retrofit.Builder()
            .apply {
                addConverterFactory(GsonConverterFactory.create())
                addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                baseUrl(API_URL)
                client(get())
            }
            .build()
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    factory {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return@factory interceptor
    }
}