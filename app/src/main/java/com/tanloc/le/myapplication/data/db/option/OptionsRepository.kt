package com.tanloc.le.myapplication.data.db.option

import com.tanloc.le.myapplication.model.Options
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class OptionsRepository @Inject constructor(private val optionsDao: OptionDao) : OptionsRepo {
    override fun isOptionsRepoEmpty(): Observable<Boolean> {
        return Observable.just(optionsDao.loadAll().isEmpty())
    }

    override fun insertOptions(options: List<Options>): Observable<Boolean> {
        optionsDao.insertAll(options)
        return return Observable.just(true);
    }

    override fun loadOptions(questionId: Long): Single<List<Options>> {
        return Single.fromCallable { optionsDao.loadOptionsByQuestionId(questionId) };
    }
}