package com.zhixin.wedeep.legotest.legotheme

import com.zhixin.wedeep.legotest.LegoDatabase
import com.zhixin.wedeep.legotest.LegoService
import com.zhixin.wedeep.legotest.legotheme.data.LegoThemeRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LegoSetThemeModule {

    @Singleton
    @Provides
    fun provideLegoThemeRemoteDataSource(legoService: LegoService) = LegoThemeRemoteDataSource(legoService)

    @Singleton
    @Provides
    fun provideLegoThemeDao(db: LegoDatabase) = db.legoThemeDao()

}