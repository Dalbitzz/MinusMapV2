package com.example.minusmapv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HotelLasAguilasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_las_aguilas);
    }

    //METODO PARA IR AL MAPA
    public void irMapa(View view) {
        Intent intent = new Intent(this, MapaHotelLasAguilasActivity.class);
        startActivity(intent);
    }

    //METODO PARA IR HACIA ATRAS
    public void irAtras(View view) {
        Intent intent = new Intent(this, HotelesActivity.class);
        startActivity(intent);
    }
}