package com.example.indiangrid

object IndianGrid {
    fun fromLatLon(lat: Double, lon: Double): String {
        val (e, n) = UTMConverter.latLonToUTM(lat, lon)
        val ex = String.format("%07d", e.toInt())
        val ny = String.format("%07d", n.toInt())
        return "$ex $ny"
    }
}
