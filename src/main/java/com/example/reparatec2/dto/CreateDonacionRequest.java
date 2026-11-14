package com.example.reparatec2.dto;

public class CreateDonacionRequest {
    private String donante;
    private String descripcionEquipo;
    private String fecha;
    private String estado;

    // Getters y Setters
    public String getDonante() { return donante; }
    public void setDonante(String donante) { this.donante = donante; }

    public String getDescripcionEquipo() { return descripcionEquipo; }
    public void setDescripcionEquipo(String descripcionEquipo) { this.descripcionEquipo = descripcionEquipo; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
