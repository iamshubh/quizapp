package com.skay.quizapp.data.impl

import com.skay.quizapp.data.QuizDataSource
import com.skay.quizapp.data.QuizItem
import com.skay.quizapp.data.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuizRepositoryImpl(private val dataSource: QuizDataSource) : QuizRepository {

    override suspend fun getQuizItems(): List<QuizItem> = withContext(Dispatchers.IO) {
        dataSource.fetchItems()
    }
}