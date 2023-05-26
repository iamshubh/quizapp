package com.skay.quizapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuizItem(val id: String, val position: Int, val name: String, val image: String) : Parcelable