package com.example.user.apuestasamerica;

import android.graphics.Bitmap;

import com.example.user.mylibrary.Localidad;

/**
 * Created by Wilder on 08/12/2015.
 */
public class Pais {
    String nombre;
    String descripcion;
    int imagen;
    Bitmap imagenBitmap;
    Localidad localidad;

    @Override
    public String toString() {
        return getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Bitmap getImagenBitmap() {
        return imagenBitmap;
    }

    public void setImagenBitmap(Bitmap imagenBitmap) {
        this.imagenBitmap = imagenBitmap;
    }
}
