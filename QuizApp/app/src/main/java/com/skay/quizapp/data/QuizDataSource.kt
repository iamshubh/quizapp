package com.skay.quizapp.data

interface QuizDataSource {
    suspend fun fetchItems(): List<QuizItem>
}