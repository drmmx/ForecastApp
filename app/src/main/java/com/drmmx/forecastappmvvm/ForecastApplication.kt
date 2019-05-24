package com.drmmx.forecastappmvvm

import android.app.Application
import com.drmmx.forecastappmvvm.data.ApixuWeatherApiService
import com.drmmx.forecastappmvvm.data.db.ForecastDatabase
import com.drmmx.forecastappmvvm.data.network.ConnectivityInterceptor
import com.drmmx.forecastappmvvm.data.network.ConnectivityInterceptorImpl
import com.drmmx.forecastappmvvm.data.network.WeatherNetworkDataSource
import com.drmmx.forecastappmvvm.data.network.WeatherNetworkDataSourceImpl
import com.drmmx.forecastappmvvm.data.repository.ForecastRepository
import com.drmmx.forecastappmvvm.data.repository.ForecastRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ForecastApplication: Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().CurrentWeatherDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance()) }

    }
}