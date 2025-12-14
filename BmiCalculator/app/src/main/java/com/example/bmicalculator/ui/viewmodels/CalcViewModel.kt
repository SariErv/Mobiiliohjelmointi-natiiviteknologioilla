package com.example.bmicalculator.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcViewModel: ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    private val height: Int
        get() {
            return heightInput.toIntOrNull() ?: 0
        }
    private val weight: Int
        get() {
            return weightInput.toIntOrNull() ?: 0
        }

    val bmi: Float
        get() {
            return if (height > 0 && weight > 0) {
                val h =height / 100f
                weight / (h * h) }
            else 0f
        }
}