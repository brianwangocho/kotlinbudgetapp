package com.example.kotlinapp.webservice

import android.telecom.Call
import com.example.kotlinapp.models.Budget
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface Webservice{

    @GET("/budget")
    suspend fun getBudget():Response<List<Budget>>
}