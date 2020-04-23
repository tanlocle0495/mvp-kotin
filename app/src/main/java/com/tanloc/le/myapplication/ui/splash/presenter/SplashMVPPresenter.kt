package com.tanloc.le.myapplication.ui.splash.presenter

import com.tanloc.le.myapplication.base.presenter.BasePresenter
import com.tanloc.le.myapplication.base.presenter.MVPPresenter
import com.tanloc.le.myapplication.ui.splash.SplashMVPView
import com.tanloc.le.myapplication.ui.splash.interactor.SplashMVPInteractor

interface SplashMVPPresenter<T : SplashMVPView, I : SplashMVPInteractor> : MVPPresenter<T, I>{

}