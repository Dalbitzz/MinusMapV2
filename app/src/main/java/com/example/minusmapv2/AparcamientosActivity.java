package com.example.minusmapv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AparcamientosActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aparcamientos);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng TomeCano = new LatLng(28.460624715579293, -16.262388117080057);
        mMap.addMarker(new MarkerOptions().position(TomeCano).title("Tome Cano"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TomeCano, 13));
        //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptor.fromResource(R.mipmap.ic_logo_aparcamientos)));

        LatLng AvTresMayo = new LatLng(28.459794678677508, -16.256766207008294);
        mMap.addMarker(new MarkerOptions().position(AvTresMayo).title("Av. Tres De Mayo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(AvTresMayo));

        LatLng ServicioTransporte = new LatLng(28.45582254938788, -16.254243475897976);
        mMap.addMarker(new MarkerOptions().position(ServicioTransporte).title("Servicio De Transporte"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ServicioTransporte));



    }
}