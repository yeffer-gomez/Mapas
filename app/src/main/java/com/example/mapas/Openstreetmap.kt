package com.example.mapas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Polyline

class Openstreetmap : AppCompatActivity() {
    private lateinit var map: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Configuration.getInstance().load(applicationContext, android.preference.PreferenceManager.getDefaultSharedPreferences(applicationContext))
        setContentView(R.layout.activity_openstreetmap)

        // Inicializar el MapView
        map = findViewById(R.id.map)
        map.setMultiTouchControls(true)

        // Configurar el punto inicial del mapa
        val mapController = map.controller
        mapController.setZoom(16.0)
        val startPoint = GeoPoint(1.2136, -77.2811) // Ubicación PASTO
        mapController.setCenter(startPoint)

        // Agregar un marcador al mapa
        val startMarker2 = Marker(map)
        startMarker2.position = startPoint
        startMarker2.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        startMarker2.title = "Pasto"
        map.overlays.add(startMarker2)


        val polygonPoints = listOf(
            GeoPoint(1.206655, -77.281150),
            GeoPoint(1.210916, -77.283121),
            GeoPoint(1.211678, -77.281512),
            GeoPoint(1.217331, -77.283958),
            GeoPoint(1.217513, -77.283711),
            GeoPoint(1.216714, -77.283025),
            GeoPoint(1.217315, -77.282333),
            GeoPoint(1.219347, -77.278111),
            GeoPoint(1.218682, -77.277424),
            GeoPoint(1.217728, -77.277167),
            GeoPoint(1.21336, -77.27532),
            GeoPoint(1.212424, -77.275525),
            GeoPoint(1.210337, -77.273862),
            GeoPoint(1.209919, -77.274013),
            GeoPoint(1.208385, -77.276180)
        )
    // Polyline y agregar los puntos
    val polyline = Polyline()
    polyline.setPoints(polygonPoints)
    polyline.color = resources.getColor(android.R.color.holo_red_dark) // Color de la línea
    polyline.width = 10f // Grosor de la línea

    // Agrega la Polyline al mapa
    map.overlays.add(polyline)
}


}