package com.example.minusmapv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    //VARIABLES
    EditText mEditTextEmail;
    EditText mEditTextPass;
    Button mButtonInicio;
    // TextView mTextViewRespuesta;
    Button mButtonIrReg;

    //FIREBASE
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextEmail = findViewById(R.id.editTextEmail);
        mEditTextPass = findViewById(R.id.editTextPassword);
        mButtonInicio = findViewById(R.id.btnIniciar);
        mButtonIrReg = findViewById(R.id.btnIrRegistar);

        mAuth = FirebaseAuth.getInstance();

        mButtonIrReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistroActivity.class));
            }
        });

        mButtonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailUser = mEditTextEmail.getText().toString().trim();
                String passUser = mEditTextPass.getText().toString().trim();

                if(emailUser.isEmpty() || passUser.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Ingrese los datos", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(emailUser, passUser);

                }
            }
        });
    }

    private void loginUser(String emailUser, String passUser) {

        mAuth.signInWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    finish();
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    Toast.makeText(MainActivity.this, "Sesión iniciada", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}