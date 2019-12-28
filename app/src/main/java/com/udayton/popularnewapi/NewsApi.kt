package com.udayton.popularnewapi

import com.example.rxjava2newsapi.model.Article
import com.example.rxjava2newsapi.model.TopHeadlines
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*
import java.lang.StringBuilder

interface NewsApi {
    companion object {
        const val KEY = "5717501955f848f986135ad4e81c7202"
    }

    //?country=us&category=business&apiKey=5717501955f848f986135ad4e81c7202
    @GET("top-headlines")
    fun topHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Observable<TopHeadlines>
}