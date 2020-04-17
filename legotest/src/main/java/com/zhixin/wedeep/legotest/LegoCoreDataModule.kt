package com.zhixin.wedeep.legotest

import android.app.Application
import com.zhixin.wedeep.common.api.AuthInterceptor
import com.zhixin.wedeep.common.di.LegoAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * Dagger module to provide core data functionality.
 */
@Module
class LegoCoreDataModule {

    @LegoAPI
    @Provides
    fun providePrivateOkHttpClient(
            upstreamClient: OkHttpClient
    ): OkHttpClient {
        return upstreamClient.newBuilder()
                .addInterceptor(AuthInterceptor("c1fe8e9d40f3b20cf375d29026688e01")).build()
    }

    @Singleton
    @Provides
    fun provideDb(app: Application) = LegoDatabase.getInstance(app)

}
