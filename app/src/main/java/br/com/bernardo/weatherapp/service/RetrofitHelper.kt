package br.com.bernardo.weatherapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    companion object {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://goweather.herokuapp.com/weather/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}