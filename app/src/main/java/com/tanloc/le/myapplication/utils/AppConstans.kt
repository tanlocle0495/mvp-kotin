package com.tanloc.le.myapplication.utils

import android.R
import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.core.graphics.drawable.toDrawable
import java.io.IOException
import java.io.InputStream
import java.util.regex.Matcher
import java.util.regex.Pattern


object AppConstans {

    internal val APP_DB_NAME = "mydb_mvp.db"
    internal val PREF_NAME = "mindorks_pref"
    internal val SEED_DATABASE_QUESTIONS = "seed/questions.json"
    internal val SEED_DATABASE_OPTIONS = "seed/options.json"
    internal val EMPTY_EMAIL_ERROR = 1001
    internal val INVALID_EMAIL_ERROR = 1002
    internal val EMPTY_PASSWORD_ERROR = 1003
    internal val LOGIN_FAILURE = 1004
    internal val NULL_INDEX = -1L

    enum class LoggedInMode constructor(val type: Int) {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3)
    }

    /// check email


}