package com.example.minusmapv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PiscinasNaturalesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piscinas_naturales);
    }

    //METODO PARA IR AL MAPA
    public  void irMapa(View view) {
        Intent intent = new Intent(this, MapaPiscinasNaturalesActivity.class);
        startActivity(intent);
    }

    //METODO PARA VOLVER HACIA ATRAS
    public void irAtras (View view) {
        Intent intent = new Intent(this, PiscinasActivity.class);
        startActivity(intent);
    }
}