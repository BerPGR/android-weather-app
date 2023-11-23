package br.com.bernardo.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.bernardo.weatherapp.databinding.ActivityMainBinding
import br.com.bernardo.weatherapp.model.Tempo
import br.com.bernardo.weatherapp.service.RetrofitHelper
import br.com.bernardo.weatherapp.service.TempoAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }

    private val retrofit by lazy {
        RetrofitHelper.retrofit
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                getCityWeather()
            }
        }
    }

    private suspend fun getCityWeather() {
        var weather: Response<Tempo>? = null
        val cidade = binding.editCityName.text.toString()
        binding.editCityName.setText("")

        try {
            val tempoAPI = retrofit.create(TempoAPI::class.java)
            weather = tempoAPI.getCityWeather(cidade)
        }
        catch (e: Exception) {
            e.printStackTrace()
            Log.i("info_tempoAPI", "Não foi possível realizar a busca")
        }

        if (weather != null) {
            if (weather.isSuccessful) {
                val result = weather.body()
                val temperature = result?.temperature
                val vento = result?.wind
                withContext(Dispatchers.Main) {
                    binding.textResultado.text = "$cidade: $temperature - $vento"
                }
            }
        }
    }
}