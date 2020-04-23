package com.tanloc.le.myapplication.data.db.questions

import com.tanloc.le.myapplication.model.Question
import io.reactivex.Observable

interface QuestionRepo {

    fun isQuestionsRepoEmpty(): Observable<Boolean>

    fun insertQuestions(questions: List<Question>): Observable<Boolean>

    fun loadQuestions(): Observable<List<Question>>
}