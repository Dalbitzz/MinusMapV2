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

public class MapaCiudadDeportivaActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    //VARIABLES
    TextView textLatitud, textLongitud;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_ciudad_deportiva);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.Mapa);
        mapFragment.getMapAsync(this);
    }

    //METODO PARA VER LA LOCALIZACION EN EL MAPA
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng CiudadDeportiva = new LatLng(28.13874093596008, -15.632554133718747);
        mMap.addMarker(new MarkerOptions().position(CiudadDeportiva).title("Ciudad Deportiva de Guia"));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CiudadDeportiva, 20));
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

    //METODO PARA VOLVER A PISCINAS
    public void volverPiscinas (View view) {
        Intent intent = new Intent(this, PiscinasActivity.class);
        startActivity(intent);
    }
}