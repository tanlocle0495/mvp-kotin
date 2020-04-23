package com.tanloc.le.myapplication.ui.splash.interactor

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.internal.`$Gson$Types`
import com.tanloc.le.myapplication.base.interactor.BaseInteractor
import com.tanloc.le.myapplication.data.db.option.OptionsRepo
import com.tanloc.le.myapplication.data.db.questions.QuestionRepo
import com.tanloc.le.myapplication.data.prefers.PreferenceHelper
import com.tanloc.le.myapplication.model.Options
import com.tanloc.le.myapplication.model.Question
import com.tanloc.le.myapplication.network.ApiHelper
import com.tanloc.le.myapplication.utils.AppConstans
import com.tanloc.le.myapplication.utils.FileUtils
import io.reactivex.Observable
import javax.inject.Inject

class SplashInteractor @Inject constructor(
    private val mContext: Context,// context
    private val questionRepoHelper: QuestionRepo, // db
    private val optionsRepoHelper: OptionsRepo,//db
    preferenceHelper: PreferenceHelper,//
    apiHelper: ApiHelper//
) : BaseInteractor(preferenceHelper, apiHelper), SplashMVPInteractor {

    override fun seedQuestions(): Observable<Boolean> {
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()

        return questionRepoHelper.isQuestionsRepoEmpty().concatMap { isEmpty ->
            //load from local first
            if (isEmpty) {
                val type = `$Gson$Types`.newParameterizedTypeWithOwner(
                    null,
                    List::class.java,
                    Question::class.java
                )
                val questionList = gson.fromJson<List<Question>>(
                    FileUtils.loadJSONFromAsset(
                        mContext,
                        AppConstans.SEED_DATABASE_QUESTIONS
                    ),
                    type
                )
                questionRepoHelper.insertQuestions(questionList)
            } else
                Observable.just(false)
        }
    }

    override fun seedOptions(): Observable<Boolean> {
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()
        return optionsRepoHelper.isOptionsRepoEmpty().concatMap { isEmpty ->
            if (isEmpty) {
                val type = `$Gson$Types`.newParameterizedTypeWithOwner(
                    null,
                    List::class.java,
                    Options::class.java
                )
                val optionsList = gson.fromJson<List<Options>>(
                    FileUtils.loadJSONFromAsset(
                        mContext,
                        AppConstans.SEED_DATABASE_OPTIONS
                    ),
                    type
                )
                optionsRepoHelper.insertOptions(optionsList)
            } else
                Observable.just(false)
        }
    }

    override fun getQuestion(): Observable<List<Question>> {
        return questionRepoHelper.loadQuestions()
    }

}



