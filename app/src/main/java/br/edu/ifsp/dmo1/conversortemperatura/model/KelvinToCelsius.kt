package br.edu.ifsp.dmo1.conversortemperatura.model

object KelvinToCelsius:ToCelsius {
    override fun converter(temperature: Double): Double {
        return temperature - 273.15
    }
}