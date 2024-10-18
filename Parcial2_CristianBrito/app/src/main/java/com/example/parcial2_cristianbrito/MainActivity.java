package com.example.parcial2_cristianbrito;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edt_usuario, edt_contraseña;
    Button btn_ingresar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String dataUserCache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edt_usuario = findViewById(R.id.edt_usuario);
        edt_contraseña = findViewById(R.id.edt_contraseña);
        btn_ingresar = findViewById(R.id.btn_ingresar);

        sharedPreferences = getSharedPreferences(dataUserCache,modo_private);
        editor = sharedPreferences.edit();

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt_usuario.getText().toString().equalsIgnoreCase("") || edt_contraseña.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this,"Los campos no pueden estar vacios",Toast.LENGTH_LONG).show();
                }else{
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Usuario", edt_usuario.getText().toString());
                    editor.putString("Contraseña",edt_contraseña.getText().toString());
                    editor.apply();

                    Intent Pantalla = new Intent(MainActivity.this,SegundaPantalla.class);
                    startActivity(Pantalla);
                    finish();
                }
            }
        });
    }
}