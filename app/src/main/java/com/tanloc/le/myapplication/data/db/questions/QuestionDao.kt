package com.tanloc.le.myapplication.data.db.questions

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tanloc.le.myapplication.model.Question


@Dao
interface QuestionsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(question: List<Question>)

    @Query("SELECT * FROM questions")
    fun loadAll(): List<Question>
}