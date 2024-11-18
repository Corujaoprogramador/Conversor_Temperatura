package br.edu.ifsp.dmo1.conversortemperatura.model

interface ToFahrenheit:TemperatureConverter {
    override fun getScale()="°F"
}