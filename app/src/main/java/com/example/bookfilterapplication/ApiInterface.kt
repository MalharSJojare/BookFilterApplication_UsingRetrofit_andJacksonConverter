package com.example.books

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("books")
    suspend fun getBooks():List<Books>
}