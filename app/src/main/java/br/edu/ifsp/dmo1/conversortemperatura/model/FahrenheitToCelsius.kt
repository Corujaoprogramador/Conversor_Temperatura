package br.edu.ifsp.dmo1.conversortemperatura.model

object FahrenheitToCelsius:ToCelsius {
    override fun converter(temperature: Double): Double {
        return (temperature - 32) / 1.8
    }
}