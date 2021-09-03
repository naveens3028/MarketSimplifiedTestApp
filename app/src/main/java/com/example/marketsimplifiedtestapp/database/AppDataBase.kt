package com.example.marketsimplifiedtestapp.database

import android.content.Context
import androidx.room.*
import com.example.marketsimplifiedtestapp.database.dao.DataModelDao
import com.example.marketsimplifiedtestapp.database.model.MyData
import com.example.marketsimplifiedtestapp.database.model.OwnerConvertor

@Database(
    entities = [MyData::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(OwnerConvertor::class)
abstract class AppDataBase : RoomDatabase() {

    abstract val dataModelDao: DataModelDao

    companion object {

        val DB_NAME = "marketsimplified"
        private var INSTANCE: AppDataBase? = null
        private val sLock = Any()

        fun getInstance(context: Context): AppDataBase? {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java, DB_NAME
                    )
                        .addMigrations()
                        .allowMainThreadQueries()
                        .build()
                }
                return INSTANCE
            }
        }
    }

}