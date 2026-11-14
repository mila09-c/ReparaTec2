package com.example.reparatec2.models;

public class Equipo {
    private int id;
    private String tipo;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private String problemaReportado;
    private String estado;
    private int usuarioId;

    public Equipo() {
    }

    public Equipo(int id, String tipo, String marca, String modelo, String numeroSerie,
                  String problemaReportado, String estado, int usuarioId) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.problemaReportado = problemaReportado;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }

    public String getProblemaReportado() { return problemaReportado; }
    public void setProblemaReportado(String problemaReportado) { this.problemaReportado = problemaReportado; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
}