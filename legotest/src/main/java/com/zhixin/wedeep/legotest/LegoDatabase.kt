package com.zhixin.wedeep.legotest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.zhixin.wedeep.common.data.Converters
import com.zhixin.wedeep.legotest.legoset.data.LegoSet
import com.zhixin.wedeep.legotest.legoset.data.LegoSetDao
import com.zhixin.wedeep.legotest.legotheme.data.LegoTheme
import com.zhixin.wedeep.legotest.legotheme.data.LegoThemeDao
import com.zhixin.wedeep.legotest.worker.SeedDatabaseWorker

/**
 * The Room database for this app
 */
@Database(entities = [LegoTheme::class,
    LegoSet::class],
        version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class LegoDatabase : RoomDatabase() {

    abstract fun legoSetDao(): LegoSetDao

    abstract fun legoThemeDao(): LegoThemeDao


    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: LegoDatabase? = null

        fun getInstance(context: Context): LegoDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): LegoDatabase {
            return Room.databaseBuilder(context, LegoDatabase::class.java, "legocatalog-db")
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    })
                    .build()
        }
    }
}
