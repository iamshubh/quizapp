package com.skay.quizapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class QuizApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var _context: Context? = null

        // backing field is generated in case of var, so it is necessary in case of val type
        internal val context: Context
            get() = _context!!
    }

    override fun onCreate() {
        super.onCreate()
        _context = this
    }
}