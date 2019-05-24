package com.drmmx.forecastappmvvm.data.network

import androidx.lifecycle.LiveData
import com.drmmx.forecastappmvvm.data.network.responce.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
}