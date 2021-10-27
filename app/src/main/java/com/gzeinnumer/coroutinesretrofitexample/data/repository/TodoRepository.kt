package com.gzeinnumer.coroutinesretrofitexample.data.repository

import com.gzeinnumer.coroutinesretrofitexample.data.Webservices
import com.gzeinnumer.coroutinesretrofitexample.data.myApi

//todo 9
class TodoRepository {
    private var services: Webservices = myApi

    suspend fun getTodo(id: Int) = services.getTodo(id)
}