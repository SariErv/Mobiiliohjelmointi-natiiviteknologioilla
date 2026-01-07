package com.example.weatherapp.data

import com.example.weatherapp.models.SearchResponse
import com.example.weatherapp.models.WeatherResponse
import com.example.weatherapp.network.WeatherClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class WeatherRepository {
    private val client = WeatherClient.client

    suspend fun getCityWeather(city: String): WeatherResponse {
        //Haetaan sijainnin koordinaatit
        val searchCity = "https://geocoding-api.open-meteo.com/v1/search?name=$city&count=1&language=en&format=json"
        val searchResponse = client.get(searchCity).body<SearchResponse>()

        //Kaupunkia ei löydy, annetaan virheilmoitus. Estää sovelluksen kaatumisen.
        val location = searchResponse.results?.firstOrNull()
           ?: throw Exception("Kaupunkia ei ole olemassa, syötä kaupunki.")

        //Haetaan säätiedot koordinaateilla ja palautetaan ne
        val weatherUrl = "https://api.open-meteo.com/v1/forecast?latitude=${location.latitude}&longitude=${location.longitude}&current=temperature_2m,relative_humidity_2m,wind_speed_10m&wind_speed_unit=ms"

        return client.get(weatherUrl).body()
    }
}
