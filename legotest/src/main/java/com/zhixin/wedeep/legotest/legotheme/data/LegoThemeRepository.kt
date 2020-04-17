package com.zhixin.wedeep.legotest.legotheme.data

import com.zhixin.wedeep.common.data.resultLiveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository module for handling data operations.
 */
@Singleton
class LegoThemeRepository @Inject constructor(private val dao: LegoThemeDao,
                                              private val remoteSource: LegoThemeRemoteDataSource) {

    val themes = resultLiveData(
            databaseQuery = { dao.getLegoThemes() },
            networkCall = { remoteSource.fetchData() },
            saveCallResult = { dao.insertAll(it.results) })

}
