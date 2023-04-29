package com.example.minusmapv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PiscinasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piscinas);
    }

    //METODO PARA IR A LA EXOLICACION DEL CENTRO DEPORTIVO
    public void irCentroDeportivo (View view) {
        Intent intent = new Intent(this, CentroDeportivoActivity.class);
        startActivity(intent);
    }

    //METODO PARA IR A LA PISCINA NATURAL BAJAMAR
    public void irPiscinasNaturales (View view) {
        Intent intent = new Intent(this, PiscinasNaturalesActivity.class);
        startActivity(intent);
    }

    //METODO PARA IR A CIUDAD DEPORTIVA DE GUIA
    public void irCiudadDeportiva (View view) {
        Intent intent = new Intent(this, CiudadDeportivaActivity.class);
        startActivity(intent);
    }

    //METODO PARA IR HACIA ATRAS
    public void irAtras(View view)  {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}