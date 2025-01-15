package com.example.mapas
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mapas.databinding.ActivityMaps2Binding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.PolylineOptions

class MainActivity : AppCompatActivity(),  OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMaps2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMaps2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Coordenadas
        val polygonPoints = listOf(
            LatLng(1.206633, -77.281110),
            LatLng(1.210913, -77.283213),
            LatLng(1.211702, -77.281529),
            LatLng(1.217512, -77.284048),
            LatLng(1.217679, -77.283881),
            LatLng(1.216769, -77.283062),
            LatLng(1.217345, -77.282348),
            LatLng(1.219363, -77.278145),
            LatLng(1.218650, -77.277448),
            LatLng(1.217724, -77.277220),
            LatLng(1.213416, -77.275399),
            LatLng(1.212400, -77.275596),
            LatLng(1.210369, -77.273930),
            LatLng(1.209916, -77.274160),
            LatLng(1.208430, -77.276233),
        )

        // Dibuja el polyline (línea)
        val polylineOptions = PolylineOptions()
            .addAll(polygonPoints)
            .color(Color.RED)
            .width(10f)

        // Añade la línea al mapa
        mMap.addPolyline(polylineOptions)

        // Ajustar la cámara
        val boundsBuilder = LatLngBounds.Builder()
        for (point in polygonPoints) {
            boundsBuilder.include(point)
        }
        val bounds = boundsBuilder.build()
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50))
    }

}