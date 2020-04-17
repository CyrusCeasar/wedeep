package com.zhixin.wedeep.legotest.legotheme.data

import com.zhixin.wedeep.common.api.BaseDataSource
import com.zhixin.wedeep.legotest.LegoService
import javax.inject.Inject

/**
 * Works with the Lego API to get data.
 */
class LegoThemeRemoteDataSource @Inject constructor(private val service: LegoService) : BaseDataSource() {

    suspend fun fetchData() = getResult { service.getThemes(1, 1000, "-id") }

}
