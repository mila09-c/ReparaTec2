package com.example.reparatec2.models;

public class Donacion {
    private int id;
    private String donante;
    private String descripcionEquipo;
    private String fecha;
    private String estado;

    public Donacion(int id, String donante, String descripcionEquipo, String fecha, String estado) {
        this.id = id;
        this.donante = donante;
        this.descripcionEquipo = descripcionEquipo;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Getters
    public int getId() { return id; }
    public String getDonante() { return donante; }
    public String getDescripcionEquipo() { return descripcionEquipo; }
    public String getFecha() { return fecha; }
    public String getEstado() { return estado; }

    // Setters
    public void setDonante(String donante) { this.donante = donante; }
    public void setDescripcionEquipo(String descripcionEquipo) { this.descripcionEquipo = descripcionEquipo; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setEstado(String estado) { this.estado = estado; }
}
