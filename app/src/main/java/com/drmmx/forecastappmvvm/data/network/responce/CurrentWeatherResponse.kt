package com.drmmx.forecastappmvvm.data.network.responce

import com.drmmx.forecastappmvvm.data.db.entity.CurrentWeatherEntry
import com.drmmx.forecastappmvvm.data.db.entity.Location
import com.google.gson.annotations.SerializedName


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)