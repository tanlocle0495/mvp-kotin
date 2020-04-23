package com.tanloc.le.myapplication.ui.splash.interactor

import com.tanloc.le.myapplication.base.interactor.BaseInteractor
import com.tanloc.le.myapplication.base.interactor.MVPInteractor
import com.tanloc.le.myapplication.model.Question
import io.reactivex.Observable

interface SplashMVPInteractor: MVPInteractor {
    fun seedQuestions(): Observable<Boolean>
    fun seedOptions(): Observable<Boolean>
    fun getQuestion(): Observable<List<Question>>
}