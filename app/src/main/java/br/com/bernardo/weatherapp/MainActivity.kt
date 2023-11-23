package br.com.bernardo.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.bernardo.weatherapp.databinding.ActivityMainBinding
import br.com.bernardo.weatherapp.service.RetrofitHelper

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
    }
}