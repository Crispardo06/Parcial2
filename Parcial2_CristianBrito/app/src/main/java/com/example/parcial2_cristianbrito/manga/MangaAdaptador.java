package com.example.parcial2_cristianbrito.manga;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2_cristianbrito.R;
import com.example.parcial2_cristianbrito.clases.Manga;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MangaAdaptador extends RecyclerView.Adapter<MangaAdaptador.ViewHolder> {

    private List<Manga> datos;
    private OnItemClickListener listener;

    public MangaAdaptador(List<Manga> datos, OnItemClickListener listener) {
        this.datos = datos;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_nombre_manga, txt_autor_manga, txt_fecha_manga;
        ImageView img_manga;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_nombre_manga = itemView.findViewById(R.id.txt_nombre_manga);
            txt_autor_manga = itemView.findViewById(R.id.txt_autor_manga);
            txt_fecha_manga = itemView.findViewById(R.id.txt_fecha_manga);
            img_manga = itemView.findViewById(R.id.img_manga);
        }

        public void Unir(Manga dato) {
            txt_nombre_manga.setText(dato.getNombre());
            txt_autor_manga.setText(dato.getAutor());
            txt_fecha_manga.setText(dato.getFecha());
            Picasso.get().load(dato.getImagen()).into(img_manga);
        }
    }

    @NonNull
    @Override
    public MangaAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manga, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Manga dato = datos.get(position);
        holder.Unir(dato);

        holder.itemView.setOnClickListener(view -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}