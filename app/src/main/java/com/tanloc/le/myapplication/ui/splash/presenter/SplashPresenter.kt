package com.tanloc.le.myapplication.ui.splash.presenter

import com.tanloc.le.myapplication.base.presenter.BasePresenter
import com.tanloc.le.myapplication.base.presenter.MVPPresenter
import com.tanloc.le.myapplication.model.Question
import com.tanloc.le.myapplication.ui.splash.SplashMVPView
import com.tanloc.le.myapplication.ui.splash.interactor.SplashInteractor
import com.tanloc.le.myapplication.ui.splash.interactor.SplashMVPInteractor
import com.tanloc.le.myapplication.utils.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashPresenter<V : SplashMVPView, I : SplashMVPInteractor> @Inject constructor(
    interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor = interactor,
    schedulerProvider = schedulerProvider,
    compositeDisposable = disposable
), SplashMVPPresenter<V, I> {


    override fun onAttach(view: V?) {
        feedInDatabase()// thuc hien goi
    }

    // da
    private fun feedInDatabase() = interactor?.let {
        compositeDisposable.add(it.seedQuestions()
            .flatMap { interactor?.seedOptions() }// no xuat ra mot observable thanh mot obserbable
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe {
                getView()?.let { decideActivityToOpen() }
            }
        )
    }

    // kiem tra de login vao activity nao
    private fun decideActivityToOpen() {
        return getView().let {
            if (isUserLoggedIn())
                it!!.openMainActivity()
            else
                it!!.openLoginActivity()
        }
    }

    // check logged in
    private fun isUserLoggedIn(): Boolean {
        interactor?.let { return it.isUserLoggedIn() }
        return false
    }


}