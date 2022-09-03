package com.antoniaggo.mismascotas;

public class Mascota {
    private int foto;
    private String nombre;
    private int likes_number;

    public Mascota(int foto, String nombre, int number_like_bone) {
        this.foto = foto;
        this.nombre = nombre;
        this.likes_number = number_like_bone;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumber_like_bone() {
        return likes_number;
    }

    public void setNumber_like_bone(int number_like_bone) {
        this.likes_number = number_like_bone;
    }
}
