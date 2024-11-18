package br.edu.ifsp.dmo1.conversortemperatura.model

interface ToKelvin:TemperatureConverter {
    override fun getScale()="K"
}