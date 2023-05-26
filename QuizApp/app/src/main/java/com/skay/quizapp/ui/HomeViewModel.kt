package com.skay.quizapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skay.quizapp.common.DependencyContainer
import com.skay.quizapp.data.QuizItem
import com.skay.quizapp.data.QuizRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {


    private var _items = MutableLiveData<List<QuizItem>>()
    val items: LiveData<List<QuizItem>> = _items

    private var _currQuestion = MutableLiveData<QuizItem?>()
    val currQuestion: LiveData<QuizItem?> = _currQuestion

    private val repository: QuizRepository by lazy {
        DependencyContainer.getRepository()
    }

    fun initQuizGames() {
        viewModelScope.launch {
            val quizs = repository.getQuizItems()
            _currQuestion.postValue(quizs[0])
        }
    }

    fun handleNextQuestion() {
        val pos = currQuestion.value?.position ?: -1
        if (pos == 4) {
            _currQuestion.postValue(null)
        } else {
            val nextQu = items.value?.get(pos + 1)
            _currQuestion.postValue(nextQu);
        }
    }


}