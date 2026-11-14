package com.example.reparatec2.dto;

public class CreateEquipoRequest {
    private String tipo;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private String problemaReportado;
    private int usuarioId;

    public CreateEquipoRequest() {
    }

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

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
}