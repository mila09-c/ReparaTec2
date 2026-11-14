package com.example.reparatec2.models;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String rol;
    private String estado;

    public Usuario(int id, String nombre, String correo, String rol, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.estado = estado;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getRol() { return rol; }
    public String getEstado() { return estado; }
}