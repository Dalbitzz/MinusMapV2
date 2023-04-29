package com.example.minusmapv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HotelesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteles);
    }

    //METODO PARA IR A HOTEL COLON RAMBLA
    public void irColonRambla (View view) {
        Intent intent = new Intent(this, HotelColonRamblaActivity.class);
        startActivity(intent);
    }

    //METODO PARA IR A HACIENDA DEL CONDE
    public void irHaciendaDelConde (View view) {
        Intent intent = new Intent(this, HotelHaciendaDelCondeActivity.class);
        startActivity(intent);
    }

    //METODO PARA IR AL HOTEL LAS AGUILAS
    public void irHotelLasAguilas (View view) {
        Intent intent = new Intent(this, HotelLasAguilasActivity.class);
        startActivity(intent);
    }

    //METODO PARA IR HACIA ATRAS
    public void irAtras (View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}