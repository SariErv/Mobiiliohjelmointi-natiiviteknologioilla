package com.example.weatherapp.models

import kotlinx.serialization.Serializable

// Muutetaan JSON-data kotlin objektiksi
@Serializable
data class WeatherResponse(
    val current: Weather
)
@Serializable
data class Weather(
    val temperature_2m:Double,
    val relative_humidity_2m: Double,
    val wind_speed_10m: Double
)

@Serializable
data class SearchResponse(val results: List<SearchResult>? = null)
@Serializable
data class SearchResult(val latitude: Double, val longitude: Double)
