package com.example.tradetransit.retrofit

import retrofit2.Response
import retrofit2.http.POST
import com.example.tradetransit.model.ApiResponseLogin
import com.example.tradetransit.model.LoginBody
import retrofit2.http.Body


interface TradeApi {

    @POST("/login")
    suspend fun login(@Body loginBody: LoginBody): Response<ApiResponseLogin>

}