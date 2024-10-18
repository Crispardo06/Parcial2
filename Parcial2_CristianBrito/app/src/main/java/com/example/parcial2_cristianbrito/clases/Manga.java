package com.example.parcial2_cristianbrito.clases;

public class Manga {
    private String nombre;
    private String autor;
    private String fecha;
    private String sinopsis;
    private String imagen;

    public Manga(String imagen, String sinopsis, String fecha, String autor, String nombre) {
        this.imagen = imagen;
        this.sinopsis = sinopsis;
        this.fecha = fecha;
        this.autor = autor;
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}