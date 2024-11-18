package br.edu.ifsp.dmo1.conversortemperatura.model

interface ToCelsius: TemperatureConverter {
    override fun getScale()="°C"
}