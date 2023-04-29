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

public class MapaCentroDeportivoActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    //VARIABLES
    TextView textLatitud, textLongitud;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_centro_deportivo);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.Mapa);
        mapFragment.getMapAsync(this);
    }

    //METODO PARA VER LA LOCALIZACION EN EL MAPA
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng CentroDeportivo = new LatLng(28.452454775362206, -16.27832898770619);
        mMap.addMarker(new MarkerOptions().position(CentroDeportivo).title("Centro Deportivo de Ofra"));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CentroDeportivo, 20));
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