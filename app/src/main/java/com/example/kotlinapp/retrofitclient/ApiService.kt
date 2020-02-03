package com.example.kotlinapp.retrofitclient

import com.example.kotlinapp.models.User
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface ApiService{

    @GET("placeholder/user/{userId}")
    suspend fun getUser(
        @Path("userId")userId :String)
            :User

}