package com.gzeinnumer.coroutinesretrofitexample.data

import com.gzeinnumer.coroutinesretrofitexample.data.model.Todo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

//todo 8
interface Webservices {
    @GET("/todos/{id}")
    suspend fun getTodo(@Path("id") id: Int): Todo
}

val myApi: Webservices by lazy {
    Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Webservices::class.java)
}