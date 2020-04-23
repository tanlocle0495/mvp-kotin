package com.tanloc.le.myapplication.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.tanloc.le.myapplication.BuildConfig
import com.tanloc.le.myapplication.data.db.AppDatabase
import com.tanloc.le.myapplication.data.prefers.PreferenceHelper
import com.tanloc.le.myapplication.di.ApiKeyInfo
import com.tanloc.le.myapplication.di.PreferenceInfo
import com.tanloc.le.myapplication.data.db.option.OptionsRepo
import com.tanloc.le.myapplication.data.db.option.OptionsRepository
import com.tanloc.le.myapplication.data.db.questions.QuestionRepo
import com.tanloc.le.myapplication.data.db.questions.QuestionRepository
import com.tanloc.le.myapplication.data.prefers.AppPrefenHelper

import com.tanloc.le.myapplication.network.ApiHeader
import com.tanloc.le.myapplication.network.ApiHelper
import com.tanloc.le.myapplication.network.AppApiHelper
import com.tanloc.le.myapplication.utils.AppConstans
import com.tanloc.le.myapplication.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppConstans.APP_DB_NAME).build()

    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstans.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPrefenHelper): PreferenceHelper =
        appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: PreferenceHelper)
            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(
        apiKey = apiKey,
        userId = preferenceHelper.getCurrentUserId(),
        accessToken = preferenceHelper.getAccessToken()
    )

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    internal fun provideQuestionRepoHelper(appDatabase: AppDatabase): QuestionRepo =
        QuestionRepository(appDatabase.questionsDao())

    @Provides
    @Singleton
    internal fun provideOptionsRepoHelper(appDatabase: AppDatabase): OptionsRepo =
        OptionsRepository(appDatabase.optionsDao())

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return SchedulerProvider();
    }

}
