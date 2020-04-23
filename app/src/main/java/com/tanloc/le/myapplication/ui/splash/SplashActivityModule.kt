package com.tanloc.le.myapplication.ui.splash

import com.tanloc.le.myapplication.ui.splash.interactor.SplashInteractor
import com.tanloc.le.myapplication.ui.splash.interactor.SplashMVPInteractor
import com.tanloc.le.myapplication.ui.splash.presenter.SplashMVPPresenter
import com.tanloc.le.myapplication.ui.splash.presenter.SplashPresenter
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {
    @Provides
    internal fun provideSplashInteractor(splashInteractor: SplashInteractor): SplashMVPInteractor = splashInteractor

    @Provides
    internal fun provideSplashPresenter(splashPresenter: SplashPresenter<SplashMVPView, SplashMVPInteractor>)
            : SplashMVPPresenter<SplashMVPView, SplashMVPInteractor> = splashPresenter
}