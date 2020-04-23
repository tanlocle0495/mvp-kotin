package com.tanloc.le.myapplication.base.interactor

interface MVPInteractor {
    fun isUserLoggedIn(): Boolean// check user loggedin
    fun performUserLogout()
}