package com.skay.quizapp.data.impl

import com.skay.quizapp.common.DependencyContainer
import com.skay.quizapp.data.QuizDataSource
import com.skay.quizapp.data.QuizItem
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class LocalDataSource : QuizDataSource {

    override suspend fun fetchItems(): List<QuizItem> {
        val text = loadFromFile()
        return parseMovies(text)
    }

    private fun parseMovies(text: String): List<QuizItem> {
        val json = JSONObject(text)
        val data = json.optJSONArray("data")

        val items = mutableListOf<QuizItem>()
        data?.let {
            0.until(it.length()).onEach { i ->
                it.optJSONObject(i)?.let { obj ->
                    items.add(
                        QuizItem(
                            id = obj.optString("id"),
                            name = obj.optString("name"),
                            position = obj.optInt("position"),
                            image = obj.optString("imgUrl")
                        )
                    )
                }
            }
        }
        return items
    }

    private fun loadFromFile(): String {
        var text = ""
        val context = DependencyContainer.getContext()
        try {
            val inputStream: InputStream = context.resources.assets.open("quiz.txt")

            val size: Int = inputStream.available()
            val buffer = ByteArray(size)

            inputStream.read(buffer)
            text = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return text
    }
}

fun main() {
    LocalDataSource()
}