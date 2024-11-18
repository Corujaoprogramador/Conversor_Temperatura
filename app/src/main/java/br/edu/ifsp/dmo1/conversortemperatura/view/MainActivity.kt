package br.edu.ifsp.dmo1.conversortemperatura.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.conversortemperatura.R
import br.edu.ifsp.dmo1.conversortemperatura.databinding.ActivityMainBinding
import br.edu.ifsp.dmo1.conversortemperatura.model.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var converterStrategy: TemperatureConverter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListener()
    }

    private fun setClickListener() {
        binding.btnCelsiusToFahrenheit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                handleConversion(CelsiusToFahrenheit)
            }
        })

        binding.btnCelsiusToKelvin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                handleConversion(CelsiusToKelvin)
            }
        })

        binding.btnFahrenheitToCelsius.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                handleConversion(FahrenheitToCelsius)
            }
        })

        binding.btnFahrenheitToKelvin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                handleConversion(FahrenheitToKelvin)
            }
        })

        binding.btnKelvinToCelsius.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                handleConversion(KelvinToCelsius)
            }
        })

        binding.btnKelvinToFahrenheit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                handleConversion(KelvinToFahrenheit)
            }
        })
    }

    private fun readTemperature(): Double {
        return try {
            binding.edittextTemperature.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            throw NumberFormatException("Input Error")
        }
    }

    private fun handleConversion(strategy: TemperatureConverter) {
        converterStrategy = strategy

        try {
            val inputValue = readTemperature()
            val result = converterStrategy.converter(inputValue)
            binding.textviewResultNumber.text = String.format("%.2f %s", result, converterStrategy.getScale())

            binding.textviewResultMessage.text = when (converterStrategy) {
                is CelsiusToKelvin -> getString(R.string.msgCtoK)
                is CelsiusToFahrenheit -> getString(R.string.msgCtoF)
                is FahrenheitToKelvin -> getString(R.string.msgFtoK)
                is FahrenheitToCelsius -> getString(R.string.msgFtoC)
                is KelvinToCelsius -> getString(R.string.msgKtoC)
                is KelvinToFahrenheit -> getString(R.string.msgKtoF)
                else -> getString(R.string.error_popup_notify)
            }
        } catch (e: Exception) {
            Toast.makeText(this, getString(R.string.error_popup_notify), Toast.LENGTH_SHORT).show()
            Log.e("APP_DMO", e.stackTraceToString())
        }
    }
}

