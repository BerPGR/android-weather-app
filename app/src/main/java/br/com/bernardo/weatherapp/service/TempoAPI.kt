package br.com.bernardo.weatherapp.service

import retrofit2.http.GET
import retrofit2.http.Path

interface TempoAPI {

    @GET("{city}")
    suspend fun getCityWeather(
        @Path("city") city: String
    )
}