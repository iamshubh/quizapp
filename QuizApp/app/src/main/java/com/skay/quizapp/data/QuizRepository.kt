package com.skay.quizapp.data

interface QuizRepository {
    suspend fun getQuizItems(): List<QuizItem>
}