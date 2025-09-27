package com.example.indiangrid

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng

class MapFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mapView: MapView
    private var gmap: GoogleMap? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_map, container, false)
        mapView = v.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        val btnGoto: Button = v.findViewById(R.id.btnGoto)
        btnGoto.setOnClickListener { showGotoDialog() }

        return v
    }

    override fun onMapReady(googleMap: GoogleMap) {
        gmap = googleMap
        gmap?.uiSettings?.isCompassEnabled = false
        gmap?.mapType = GoogleMap.MAP_TYPE_NORMAL
        val start = LatLng(22.5726, 88.3639)
        gmap?.moveCamera(CameraUpdateFactory.newLatLngZoom(start, 12f))
    }

    private fun showGotoDialog() {
        val b = AlertDialog.Builder(requireContext())
        b.setTitle("Go to Indian Grid or Lat/Lon")
        b.setMessage("Enter a 14-figure Indian Grid (XXXXXXXXXXXXXX) or lat,lon - feature placeholder.")
        b.setPositiveButton("OK", null)
        b.show()
    }
}
