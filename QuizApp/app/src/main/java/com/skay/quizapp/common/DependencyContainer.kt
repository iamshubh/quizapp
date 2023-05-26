package com.skay.quizapp.common

import android.content.Context
import com.skay.quizapp.QuizApplication
import com.skay.quizapp.data.QuizDataSource
import com.skay.quizapp.data.QuizRepository
import com.skay.quizapp.data.impl.LocalDataSource
import com.skay.quizapp.data.impl.QuizDataSourceImpl
import com.skay.quizapp.data.impl.QuizRepositoryImpl

object DependencyContainer {
    private var dataSource: QuizDataSource? = null;
    private var repository: QuizRepository? = null

    fun getRepository(): QuizRepository {
        if (repository == null) {
            repository = QuizRepositoryImpl(getDataSource())
        }
        return repository!!
    }

    fun getDataSource(): QuizDataSource {
        if (dataSource == null) {
            dataSource = LocalDataSource()
        }
        return dataSource!!
    }

    fun getContext(): Context = QuizApplication.context
}