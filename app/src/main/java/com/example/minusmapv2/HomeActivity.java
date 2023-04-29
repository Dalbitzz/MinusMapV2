package com.example.minusmapv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    //VARIABLES
    Button mButtonCerrar;
    Button mButtonIrPiscinas;

    Button mButtonHoteles;

    Button mButtonRehabilitacion;

    Button mButtonAparcamientos;

    //FIREBASE
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mButtonCerrar = findViewById(R.id.btnCerrarSesion);
        mButtonIrPiscinas = findViewById(R.id.btnPiscinas);
        mButtonHoteles = findViewById(R.id.btnHoteles);
        mButtonRehabilitacion = findViewById(R.id.btnReabilitacion);
        mButtonAparcamientos = findViewById(R.id.btnAparcamientos);
        mAuth = FirebaseAuth.getInstance();

        mButtonCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CERRAR SESION
                mAuth.signOut();
                finish();
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });
    }
    //METODO PARA IR A PISCINAS
    public void irPiscinas(View view) {
        startActivity(new Intent(HomeActivity.this, PiscinasActivity.class));
        finish();
    }
    //METODO PARA IR A HOTELES
    public void irHoteles(View view) {
        startActivity(new Intent(HomeActivity.this, HotelesActivity.class));
        finish();
    }
    //METODO PARA IR A CENTROS DE REHABILITACION
    public void irAparcamientos(View view) {
        startActivity(new Intent(HomeActivity.this, CentrosRehabilitacionActivity.class));
        finish();
    }
    /*//METODO PARA IR A APARCAMIENTOS
    public void irAparcamientos(View view) {
        startActivity(new Intent(HomeActivity.this, AparcamientosActivity.class));
        finish();
    }*/
}