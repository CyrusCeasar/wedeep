package com.zhixin.wedeep.legotest.legoset.data

import com.zhixin.wedeep.common.api.BaseDataSource
import com.zhixin.wedeep.legotest.LegoService
import javax.inject.Inject

/**
 * Works with the Lego API to get data.
 */
//@OpenForTesting
class LegoSetRemoteDataSource @Inject constructor(private val service: LegoService) : BaseDataSource() {

    suspend fun fetchSets(page: Int, pageSize: Int? = null, themeId: Int? = null)
            = getResult { service.getSets(page, pageSize, themeId, "-year") }

    suspend fun fetchSet(id: String)
            = getResult { service.getSet(id) }
}
