package com.tanloc.le.myapplication.data.db.option

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tanloc.le.myapplication.model.Options

@Dao
interface OptionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(options: List<Options>)

    @Query("SELECT * FROM options WHERE question_id = :questionId")
    fun loadOptionsByQuestionId(questionId: Long): List<Options>

    @Query("SELECT * FROM options")
    fun loadAll(): List<Options>

}