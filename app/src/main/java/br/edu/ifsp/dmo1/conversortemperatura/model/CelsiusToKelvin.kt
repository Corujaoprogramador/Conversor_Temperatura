package br.edu.ifsp.dmo1.conversortemperatura.model

object CelsiusToKelvin:ToKelvin {
    override fun converter(temperature: Double): Double {
        return temperature + 273.15
    }
}