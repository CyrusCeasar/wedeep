package com.zhixin.wedeep.legotest


import com.zhixin.wedeep.common.api.ResultsResponse
import com.zhixin.wedeep.legotest.legoset.data.LegoSet
import com.zhixin.wedeep.legotest.legotheme.data.LegoTheme
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Lego REST API access points
 */
interface LegoService {



    @GET("lego/themes/")
    suspend fun getThemes(@Query("page") page: Int? = null,
                  @Query("page_size") pageSize: Int? = null,
                  @Query("ordering") order: String? = null): Response<ResultsResponse<LegoTheme>>

    @GET("lego/sets/")
    suspend fun getSets(@Query("page") page: Int? = null,
                        @Query("page_size") pageSize: Int? = null,
                        @Query("theme_id") themeId: Int? = null,
                        @Query("ordering") order: String? = null): Response<ResultsResponse<LegoSet>>

    @GET("lego/sets/{id}/")
    suspend fun getSet(@Path("id") id: String): Response<LegoSet>

}
