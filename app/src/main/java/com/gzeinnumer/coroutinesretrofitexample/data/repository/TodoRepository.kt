package com.gzeinnumer.coroutinesretrofitexample.data.repository

import com.gzeinnumer.coroutinesretrofitexample.data.Webservices
import com.gzeinnumer.coroutinesretrofitexample.data.myApi

class TodoRepository {
    private var services: Webservices = myApi

    suspend fun getTodo(id: Int) = services.getTodo(id)

    //todo 26
    suspend fun getUsers() = services.getUsers()
}