package com.tanloc.le.myapplication.data.db.option

import com.tanloc.le.myapplication.model.Options
import io.reactivex.Observable
import io.reactivex.Single

interface OptionsRepo {
    fun isOptionsRepoEmpty(): Observable<Boolean>
    fun insertOptions(options: List<Options>): Observable<Boolean>
    fun loadOptions(questionId: Long): Single<List<Options>>
}
