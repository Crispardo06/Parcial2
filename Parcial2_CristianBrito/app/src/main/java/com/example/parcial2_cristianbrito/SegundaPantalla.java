package com.example.parcial2_cristianbrito;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2_cristianbrito.clases.Manga;
import com.example.parcial2_cristianbrito.manga.MangaAdaptador;

import java.util.ArrayList;
import java.util.List;

public class SegundaPantalla extends AppCompatActivity implements MangaAdaptador.OnItemClickListener{


    RecyclerView rcv_mangas;
    Button btn_cerrar_sesion;
    List<Manga> ListaDeMangas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_pantalla);

        btn_cerrar_sesion = findViewById(R.id.btn_cerrar_sesion);
        btn_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences(dataUserCache, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                // Configurar el botón de Logout
                Button logoutButton = findViewById(R.id.btn_logout);
                logoutButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Eliminar las preferencias guardadas (logout)

                        editor.clear();  // Eliminar todos los datos guardados
                        editor.apply();

                        // Redirigir al usuario a la pantalla de LoginActivity
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();  // Finalizar MainActivity para que no se pueda volver atrás
                    }
                })
            }
        });

        rcv_mangas = findViewById(R.id.rcv_mangas);

        Manga Manga1 = new Manga("https://static.wikia.nocookie.net/onepiece/images/2/29/Volumen_103.png/revision/latest?cb=20220723112009&path-prefix=es", "Una historia de piratas en busca del tesoro supremo, el One Piece, liderados por Monkey D. Luffy.", "22 de julio de 1997", "Eiichiro Oda", "One Piece");
        Manga Manga2 = new Manga("https://images.cdn2.buscalibre.com/fit-in/360x360/1a/26/1a26bf690cb1971e644414899ad4ed7a.jpg", "La historia de Naruto Uzumaki, un joven ninja que busca reconocimiento y aspira a convertirse en Hokage.", "21 de septiembre de 1999", "Masashi Kishimoto", "Naruto");
        Manga Manga3 = new Manga("https://www.futuro.cl/wp-content/uploads/2021/04/Portada-SNK-139-713x1024.jpg", "La lucha de la humanidad contra criaturas gigantescas conocidas como Titanes.", "9 de septiembre de 2009", "Hajime Isayama", "Shingeki no Kyojin");
        Manga Manga4 = new Manga("https://ramenparados.com/wp-content/uploads/2013/02/normal_death_note_selecta.jpg", "Un estudiante de secundaria descubre un cuaderno que le permite matar a cualquiera escribiendo su nombre en él.", "2 de abril de 2003", "Tsugumi Ohba", "Death Note");
        Manga Manga5 = new Manga("https://static.wikia.nocookie.net/bokunoheroacademia/images/f/f1/Volumen_1_Panini.png/revision/latest?cb=20181110182259&path-prefix=es", "En un mundo donde las personas tienen superpoderes, un chico sin ellos se esfuerza por convertirse en un héroe.", "7 de julio de 2014", "Kohei Horikoshi", "Boku no Hero Academia");
        Manga Manga6 = new Manga("https://somoskudasai.com/wp-content/uploads/2020/11/Em6dKhVUUAEdjCv-1-edit-min.jpeg", "Un joven se convierte en cazador de demonios después de que su familia es asesinada por demonios.", "15 de febrero de 2016", "Koyoharu Gotouge", "Kimetsu no Yaiba");
        Manga Manga7 = new Manga("https://i1.whakoom.com/small/0b/27/acc7e146fe0e4517bbd63bc5cd35d935.jpg", "Las aventuras de Goku desde su infancia hasta la adultez mientras entrena en artes marciales y explora el mundo.", "20 de septiembre de 1984", "Akira Toriyama", "Dragon Ball");
        Manga Manga8 = new Manga("https://images.cdn2.buscalibre.com/fit-in/360x360/0c/8c/0c8c49d37ecc6ba7b1bd606f4b8dd9ea.jpg", "Dos hermanos utilizan la alquimia para buscar la Piedra Filosofal y restaurar sus cuerpos tras una transmutación fallida.", "11 de julio de 2001", "Hiromu Arakawa", "Fullmetal Alchemist");
        Manga Manga9 = new Manga("https://pm1.aminoapps.com/6461/cea348d34271687db6d4cbf3085c84c4cd296a41_00.jpg", "Un estudiante universitario se convierte en medio ghoul tras un encuentro con uno y lucha con su identidad.", "8 de septiembre de 2011", "Sui Ishida", "Tokyo Ghoul");
        Manga Manga10 = new Manga("https://ramenparados.com/wp-content/uploads/2018/09/tensei-shitara-1.jpg", "Un hombre es reencarnado en un mundo de fantasía como un slime con habilidades únicas y construye una nueva vida.", "Octubre de 2014", "Fuse", "Tensei shitara Slime Datta Ken");

        ListaDeMangas.add(Manga1);
        ListaDeMangas.add(Manga2);
        ListaDeMangas.add(Manga3);
        ListaDeMangas.add(Manga4);
        ListaDeMangas.add(Manga5);
        ListaDeMangas.add(Manga6);
        ListaDeMangas.add(Manga7);
        ListaDeMangas.add(Manga8);
        ListaDeMangas.add(Manga9);
        ListaDeMangas.add(Manga10);


        rcv_mangas.setLayoutManager(new LinearLayoutManager(this));
        rcv_mangas.setAdapter(new MangaAdaptador(ListaDeMangas, this));
    }

    @Override
    public void onItemClick(int position) {

        Manga Seleccion = ListaDeMangas.get(position);

        Intent Detalles = new Intent(this, DetalleManga.class);
        Detalles.putExtra("nombre", Seleccion.getNombre());
        Detalles.putExtra("autor", Seleccion.getAutor());
        Detalles.putExtra("fecha", Seleccion.getFecha());
        Detalles.putExtra("sinopsis", Seleccion.getSinopsis());
        Detalles.putExtra("imagen", Seleccion.getImagen());
        startActivity(Detalles);
    }

}