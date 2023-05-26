package com.skay.quizapp.data.impl

import com.skay.quizapp.data.QuizDataSource
import com.skay.quizapp.data.QuizItem

class QuizDataSourceImpl : QuizDataSource {
    override suspend fun fetchItems(): List<QuizItem> {
        // todo fetch from raw json file
        return listOf(
            QuizItem(
                id = "1",
                name = "Guess this item 1",
                position = 0,
                image = "https://cdn.iconscout.com/icon/free/png-256/bhim-3-69845.png"
            ),
            QuizItem(
                id = "2",
                position = 1,
                name = "Guess this item 2",
                image = "https://media.glassdoor.com/sqll/300494/flipkart-com-squarelogo-1433217726546.png"
            ),
            QuizItem(
                id = "3",
                position = 2,
                name = "Guess this item 3",
                image = "https://cdn.iconscout.com/icon/free/png-256/bhim-3-69845.png"
            ),
            QuizItem(
                id = "4",
                position = 3,
                name = "Guess this item 4",
                image = "https://media.glassdoor.com/sqll/300494/flipkart-com-squarelogo-1433217726546.png"
            )
        )
    }
}