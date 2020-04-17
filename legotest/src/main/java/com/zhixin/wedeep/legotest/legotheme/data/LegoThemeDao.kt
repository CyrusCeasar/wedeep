package com.zhixin.wedeep.legotest.legotheme.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zhixin.wedeep.legotest.legotheme.data.LegoTheme

/**
 * The Data Access Object for the LegoTheme class.
 */
@Dao
interface LegoThemeDao {

    @Query("SELECT * FROM themes ORDER BY id DESC")
    fun getLegoThemes(): LiveData<List<LegoTheme>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<LegoTheme>)
}
