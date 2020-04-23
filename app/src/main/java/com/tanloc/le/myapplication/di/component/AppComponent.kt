package com.tanloc.le.myapplication.di.component

import android.app.Application
import com.tanloc.le.myapplication.MvpApp
import com.tanloc.le.myapplication.di.builder.ActivityBuilder
import com.tanloc.le.myapplication.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MvpApp)

}