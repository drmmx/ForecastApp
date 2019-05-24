package com.drmmx.forecastappmvvm.data.repository

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean)
}