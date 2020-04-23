package com.tanloc.le.myapplication.di.builder

import com.tanloc.le.myapplication.MainActivity
import com.tanloc.le.myapplication.ui.login.LoginActivity
import com.tanloc.le.myapplication.ui.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun bindSplashActivity(): SplashMVPActivity

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (RateUsDialogFragmentProvider::class), (AboutFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [(BlogFragmentProvider::class), (OpenSourceFragmentProvider::class)])
    abstract fun bindFeedActivity(): FeedActivity

}