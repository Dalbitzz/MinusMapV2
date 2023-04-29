package com.example.minusmapv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    EditText mEditTextNombre;
    EditText mEditTextApellido;
    EditText mEditTextEmail;
    EditText mEditTextPass;
    EditText mEditTextConfPass;
    Button mButtonRegsitrar;

    //FIREBASE
    FirebaseAuth mAuth;
    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mEditTextNombre = findViewById(R.id.editTextNombre);
        mEditTextApellido = findViewById(R.id.editTextApellido);
        mEditTextEmail = findViewById(R.id.editTextEmail);
        mEditTextPass = findViewById(R.id.editTextPassword);
        mEditTextConfPass = findViewById(R.id.editTextConfPassword);
        mButtonRegsitrar = findViewById(R.id.btnRegistrar);

        mAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        mButtonRegsitrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {

        String nombre = mEditTextNombre.getText().toString();
        String apellido = mEditTextApellido.getText().toString();
        String email = mEditTextEmail.getText().toString();
        String pass = mEditTextPass.getText().toString();
        String confiPass = mEditTextConfPass.getText().toString();

        if(!nombre.isEmpty() && !apellido.isEmpty() && !email.isEmpty() && !pass.isEmpty() && !confiPass.isEmpty()) {
            if(isEmailValided(email)) {
                if(confiPass.length() >= 6 && confiPass.equals(confiPass)) {
                    createUsuario(nombre, apellido, email, confiPass);
                } else {
                    Toast.makeText(this, "La contraseña debe tener más de 6 carácteres",
                            Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "El formato del e-mail no se el correcto", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void createUsuario(String nombre, String apellido, String email, String confiPass) {
        mAuth.createUserWithEmailAndPassword(email, confiPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    String id = mAuth.getCurrentUser().getUid();
                    Map<String, Object> map = new HashMap<>();
                    map.put("Nombre", nombre);
                    map.put("Apellido", apellido);
                    map.put("E-mail", email);

                    mFirestore.collection("Usuarios").document(id).set(map).addOnCompleteListener
                            (new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()) {
                                        finish();
                                        startActivity(new Intent(RegistroActivity.this, MainActivity.class));
                                        Toast.makeText(RegistroActivity.this, "El usuario ha sido creado",
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(RegistroActivity.this, "El usuario no se ha creado",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }

    public boolean isEmailValided(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //VERIFIVACION DE USUARIO CON SESION INICIADA
    //SE DIRIJE A ENTRADA
    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser usuario = mAuth.getCurrentUser();
        if(usuario != null) {
            startActivity(new Intent(RegistroActivity.this, MainActivity.class));
            finish();
        }
    }
}