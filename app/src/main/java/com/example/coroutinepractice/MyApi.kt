package com.example.coroutinepractice

import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET("/comments")
    suspend fun getcomments(): Response<Comment>

}