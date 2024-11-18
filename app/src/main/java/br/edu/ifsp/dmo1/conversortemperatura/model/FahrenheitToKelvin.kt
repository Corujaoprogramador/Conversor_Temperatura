package br.edu.ifsp.dmo1.conversortemperatura.model

object FahrenheitToKelvin: ToKelvin {
    override fun converter(temperature: Double): Double {
        return (5.0 / 9.0) * (temperature - 32) + 273.15
    }
}
