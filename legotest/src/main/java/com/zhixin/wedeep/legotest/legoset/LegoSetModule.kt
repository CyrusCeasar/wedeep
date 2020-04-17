package com.zhixin.wedeep.legotest.legoset

import com.zhixin.wedeep.legotest.LegoService
import com.zhixin.wedeep.common.di.LegoAPI
import com.zhixin.wedeep.common.di.provideService
import com.zhixin.wedeep.legotest.LegoDatabase
import com.zhixin.wedeep.legotest.legoset.data.LegoSetRemoteDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class LegoSetModule {

    @Singleton
    @Provides
    fun provideLegoService(@LegoAPI okhttpClient: OkHttpClient,
                           converterFactory: GsonConverterFactory
    ) = provideService(okhttpClient, converterFactory, LegoService::class.java)

    @Singleton
    @Provides
    fun provideLegoSetRemoteDataSource(legoService: LegoService) = LegoSetRemoteDataSource(legoService)


    @Singleton
    @Provides
    fun provideLegoSetDao(db: LegoDatabase) = db.legoSetDao()
}