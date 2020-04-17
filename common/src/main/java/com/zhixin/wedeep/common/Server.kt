package com.zhixin.wedeep.common

object Server {
    private const val TEST_URL = "https://rebrickable.com/api/v3/"
    val url by lazy {
        when (BuildConfig.BUILD_TYPE){
            "DEBUG"-> TEST_URL
            else-> TEST_URL
        }
    }
}