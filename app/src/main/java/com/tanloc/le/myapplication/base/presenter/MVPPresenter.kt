package com.tanloc.le.myapplication.base.presenter

import com.tanloc.le.myapplication.base.interactor.MVPInteractor
import com.tanloc.le.myapplication.base.view.MVPView


interface MVPPresenter<V : MVPView, I : MVPInteractor> {
    fun onAttach(view: V?)
    fun onDetach()
    fun getView(): V?
}
