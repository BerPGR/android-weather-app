package br.com.bernardo.weatherapp.service

import br.com.bernardo.weatherapp.model.Tempo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TempoAPI {

    @GET("{city}")
    suspend fun getCityWeather(
        @Path("city") city: String
    ) : Response<Tempo>
}