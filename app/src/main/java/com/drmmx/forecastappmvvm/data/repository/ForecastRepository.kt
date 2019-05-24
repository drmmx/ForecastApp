package com.drmmx.forecastappmvvm.data.repository

import androidx.lifecycle.LiveData
import com.drmmx.forecastappmvvm.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry as UnitSpecificCurrentWeatherEntry1

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry1>
}