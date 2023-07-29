package com.example.siterecontest

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MeowInterface
{
    @GET("/")
    suspend fun getMeowFacts(@Query("count") count:Int) : Response<MeowFactsResponse>
}

