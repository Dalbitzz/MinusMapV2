package com.example.minusmapv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CiudadDeportivaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudad_deportiva);
    }

    //METODO PARA IR AL MAPA
    public void irMapa (View view) {
        Intent intent = new Intent(this, MapaCiudadDeportivaActivity.class);
        startActivity(intent);
    }

    //METODO PARA VOLVER
    public void irAtras (View view) {
        Intent intent = new Intent(this, PiscinasActivity.class);
        startActivity(intent);
    }
}