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

public class AparcamientosActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    //VARIABLES
    TextView textLatitud, textLongitud;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aparcamientos);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.Mapa);
        mapFragment.getMapAsync(this);
    }

    //METODO PARA VER LA LOCALIZACION EN EL MAPA
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng TomeCano = new LatLng(28.459430356412344, -16.25651612881615);
        mMap.addMarker(new MarkerOptions().position(TomeCano).title("Tomé Cano"));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TomeCano, 20));

        LatLng ServiTrans = new LatLng(28.455770557918605, -16.2541772425411);
        mMap.addMarker(new MarkerOptions().position(ServiTrans).title("Servicio de Transportes"));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ServiTrans, 20));

        LatLng ParqueMaritimo = new LatLng(28.453733089331894, -16.256344467417097);
        mMap.addMarker(new MarkerOptions().position(ParqueMaritimo).title("Parkin Parque Maritimo"));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ParqueMaritimo, 20));
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