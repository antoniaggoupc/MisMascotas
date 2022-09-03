package com.antoniaggo.mismascotas;

public class Mascota {
    private int foto;
    private String nombre;
    private String number_like_bone;

    public Mascota(int foto, String nombre, String number_like_bone) {
        this.foto = foto;
        this.nombre = nombre;
        this.number_like_bone = number_like_bone;
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

    public String getNumber_like_bone() {
        return number_like_bone;
    }

    public void setNumber_like_bone(String number_like_bone) {
        this.number_like_bone = number_like_bone;
    }
}
