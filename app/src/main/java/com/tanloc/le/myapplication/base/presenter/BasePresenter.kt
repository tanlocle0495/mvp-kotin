package com.tanloc.le.myapplication.base.presenter

import com.tanloc.le.myapplication.base.interactor.MVPInteractor
import com.tanloc.le.myapplication.base.view.MVPView
import com.tanloc.le.myapplication.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

// prenter connect view  to intercrator
abstract class BasePresenter<V : MVPView, I : MVPInteractor> internal constructor(
    protected var interactor: I?,
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable
) : MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view
    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}