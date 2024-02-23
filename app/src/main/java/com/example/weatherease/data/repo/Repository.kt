package com.example.weatherease.data.repo


import com.example.weatherease.data.api.Resource
import com.example.weatherease.data.api.WeatherApiService
import com.example.weatherease.data.model.WeatherData
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.TimeZone

class Repository():BaseRepo() {

    private val weatherApi = WeatherApiService.api
    suspend fun getCurrentWeather(
        lat: String,
        lon: String,
        appid: String
    ): Resource<WeatherData> {
        return safeApiCall { weatherApi.getCurrentWeather(lat,lon,appid) }
    }

    suspend fun getCurrentWeatherOf(
        cityName: String,
        appid: String
    ):Resource<WeatherData>{
        return safeApiCall { weatherApi.getCurrentWeatherOf(cityName,appid) }
    }
}