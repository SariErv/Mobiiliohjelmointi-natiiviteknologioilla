package com.example.weatherapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.WeatherRepository
import com.example.weatherapp.models.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class WeatherUiState(
    val weather: Weather? = null,
    val error: String? = null,
    val loading: Boolean = false
)

class WeatherViewModel: ViewModel() {
    private val repository = WeatherRepository()
    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState

    init {
        fetchWeather("Oulu") //Haetaan oletuksena Oulun sää
    }

    fun fetchWeather(city: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                loading = true,
                error = null
            )
            try {
                val response = repository.getCityWeather(city)
                _uiState.value = _uiState.value.copy(
                    weather = response.current,
                    loading = false
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    error = e.message,
                    loading = false
                )
            }
        }
    }
}