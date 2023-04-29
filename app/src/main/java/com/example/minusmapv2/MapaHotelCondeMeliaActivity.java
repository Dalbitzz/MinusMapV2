package com.example.minusmapv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaHotelCondeMeliaActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    //VARIABLES
    TextView textLatitud, textLongitud;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_hotel_conde_melia);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.Mapa);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng HaciendaDelConde = new LatLng(28.36962328888167, -16.858950518396362);
        mMap.addMarker(new MarkerOptions().position(HaciendaDelConde).title("Hacienda Del Conde Meber De Meliá"));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HaciendaDelConde, 20));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        textLatitud.setText("" + latLng.latitude);
        textLongitud.setText("" + latLng.longitude);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        textLatitud.setText("" + latLng.latitude);
        textLongitud.setText("" + latLng.longitude);
    }

    //METODO PARA VOLVER A HOTELES
    public void irAtras (View view) {
        Intent intent = new Intent(this, HotelesActivity.class);
        startActivity(intent);
    }
}