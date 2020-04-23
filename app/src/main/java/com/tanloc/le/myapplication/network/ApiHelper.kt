package com.tanloc.le.myapplication.network

import com.tanloc.le.myapplication.network.model.OpenSourceResponse
import com.tanloc.le.myapplication.network.model.blog.BlogResponse
import com.tanloc.le.myapplication.network.model.login.LoginRequest
import com.tanloc.le.myapplication.network.model.login.LoginResponse
import com.tanloc.le.myapplication.network.model.login.LogoutResponse
import io.reactivex.Observable

interface ApiHelper {

    // khu vuc goi api
    fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse>

    fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse>

    fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse>

    fun performLogoutApiCall(): Observable<LogoutResponse>

    fun getBlogApiCall(): Observable<BlogResponse>

    fun getOpenSourceApiCall(): Observable<OpenSourceResponse>

}