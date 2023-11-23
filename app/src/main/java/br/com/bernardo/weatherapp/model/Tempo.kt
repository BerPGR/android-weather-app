package br.com.bernardo.weatherapp.model

import br.com.bernardo.weatherapp.model.Forecast

data class Tempo(
    val description: String,
    val forecast: List<Forecast>,
    val temperature: String,
    val wind: String
)