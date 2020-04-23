package com.tanloc.le.myapplication.ui.splash

import com.tanloc.le.myapplication.base.view.MVPView

interface SplashMVPView:MVPView {
    fun showSuccessToast()
    fun showErrorToast()
    fun openMainActivity()
    fun openLoginActivity()
}