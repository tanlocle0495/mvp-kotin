package com.tanloc.le.myapplication.base.interactor

import com.tanloc.le.myapplication.data.prefers.PreferenceHelper
import com.tanloc.le.myapplication.network.ApiHelper
import com.tanloc.le.myapplication.utils.AppConstans

open class BaseInteractor constructor(
    val preferenceHelper: PreferenceHelper,
    val apiHelper: ApiHelper
) : MVPInteractor {
    init {

    }

    override fun isUserLoggedIn() =
        this.preferenceHelper.getCurrentUserLoggedInMode() != AppConstans.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type

    override fun performUserLogout() = preferenceHelper.let {
        it.setCurrentUserId(null)
        it.setAccessToken(null)
        it.setCurrentUserEmail(null)
        it.setCurrentUserLoggedInMode(AppConstans.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT)
    }

}