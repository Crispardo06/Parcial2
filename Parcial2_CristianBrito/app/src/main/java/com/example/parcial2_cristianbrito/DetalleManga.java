package com.example.parcial2_cristianbrito;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class DetalleManga extends AppCompatActivity {

    TextView txt_nombre_manga, txt_autor_manga, txt_fecha_manga, txt_sinopsis_manga;
    ImageView img_detalle_manga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_manga);

        txt_nombre_manga = findViewById(R.id.txt_nombre_manga);
        txt_autor_manga = findViewById(R.id.txt_autor_manga);
        txt_fecha_manga = findViewById(R.id.txt_fecha_manga);
        txt_sinopsis_manga = findViewById(R.id.txt_sinopsis_manga);
        img_detalle_manga = findViewById(R.id.img_detalle_manga);

        String nombre = getIntent().getStringExtra("nombre");
        String autor = getIntent().getStringExtra("autor");
        String fecha = getIntent().getStringExtra("fecha");
        String sinopsis = getIntent().getStringExtra("sinopsis");
        String imagen = getIntent().getStringExtra("imagen");

        txt_nombre_manga.setText(nombre);
        txt_autor_manga.setText(autor);
        txt_fecha_manga.setText(fecha);
        txt_sinopsis_manga.setText(sinopsis);
        Picasso.get().load(imagen).into(img_detalle_manga);
    }
}