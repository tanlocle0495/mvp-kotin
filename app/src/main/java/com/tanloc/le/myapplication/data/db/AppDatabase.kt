package com.tanloc.le.myapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tanloc.le.myapplication.data.db.option.OptionDao
import com.tanloc.le.myapplication.data.db.questions.QuestionsDao
import com.tanloc.le.myapplication.model.Options
import com.tanloc.le.myapplication.model.Question

@Database(entities = [(Question::class), (Options::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun optionsDao(): OptionDao
    abstract fun questionsDao(): QuestionsDao
}