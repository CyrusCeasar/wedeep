package com.zhixin.wedeep.common.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.zhixin.wedeep.common.BuildConfig
import com.zhixin.wedeep.common.Server
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

fun createRetrofit(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
            .baseUrl(Server.url)
            .client(okhttpClient)
            .addConverterFactory(converterFactory)
            .build()
}

fun <T> provideService(okhttpClient: OkHttpClient,
                       converterFactory: GsonConverterFactory, clazz: Class<T>): T {
    return createRetrofit(okhttpClient, converterFactory).create(clazz)
}

@Module
class NetWorkModule {


    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder().addInterceptor(interceptor)
                    .addNetworkInterceptor(StethoInterceptor())
                    .build()

    @Provides
    fun provideLoggingInterceptor() =
            HttpLoggingInterceptor().apply { level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
            GsonConverterFactory.create(gson)


    @CoroutineScropeIO
    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)
}