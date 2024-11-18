package br.edu.ifsp.dmo1.conversortemperatura.model

object KelvinToFahrenheit: ToFahrenheit {
    override fun converter(temperature: Double): Double {
        return (temperature - 273.15) * 9.0 / 5.0 + 32
    }
}
