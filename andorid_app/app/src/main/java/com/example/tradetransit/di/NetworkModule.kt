package com.example.tradetransit.di

import com.example.tradetransit.model.ApiResponseLogin
import com.example.tradetransit.retrofit.TradeApi
import com.example.tradetransit.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun provideTradeApi(retrofit: Retrofit): TradeApi {
        return retrofit.create(TradeApi::class.java)
    }
}