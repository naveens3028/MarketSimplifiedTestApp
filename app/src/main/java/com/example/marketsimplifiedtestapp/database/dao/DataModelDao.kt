package com.example.marketsimplifiedtestapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marketsimplifiedtestapp.database.model.MyData


@Dao
interface DataModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAvg(sectionItem: List<MyData>)

    @Query("SELECT * FROM MydataTable")
    fun getAll(): MutableList<MyData>

    @Query("UPDATE MydataTable SET comments=:comment WHERE id = :id")
    fun update(comment: String?, id: Int)

    @Query("SELECT * FROM MydataTable WHERE MydataTable.id = :id")
    fun findLastPage(id: Int?): MyData

}

