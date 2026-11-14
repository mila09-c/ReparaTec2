package com.example.reparatec2.models;

public class Reparacion {
    private int id;
    private int equipoId;
    private String tecnicoAsignado;
    private String diagnostico;
    private double costoEstimado;
    private String fechaIngreso;
    private String estadoOrden;

    public Reparacion(int id, int equipoId, String tecnicoAsignado, String diagnostico, double costoEstimado, String fechaIngreso, String estadoOrden) {
        this.id = id;
        this.equipoId = equipoId;
        this.tecnicoAsignado = tecnicoAsignado;
        this.diagnostico = diagnostico;
        this.costoEstimado = costoEstimado;
        this.fechaIngreso = fechaIngreso;
        this.estadoOrden = estadoOrden;
    }

    // Getters
    public int getId() { return id; }
    public int getEquipoId() { return equipoId; }
    public String getTecnicoAsignado() { return tecnicoAsignado; }
    public String getDiagnostico() { return diagnostico; }
    public double getCostoEstimado() { return costoEstimado; }
    public String getFechaIngreso() { return fechaIngreso; }
    public String getEstadoOrden() { return estadoOrden; }

    // Setters
    public void setEquipoId(int equipoId) { this.equipoId = equipoId; }
    public void setTecnicoAsignado(String tecnicoAsignado) { this.tecnicoAsignado = tecnicoAsignado; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }
    public void setCostoEstimado(double costoEstimado) { this.costoEstimado = costoEstimado; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }
    public void setEstadoOrden(String estadoOrden) { this.estadoOrden = estadoOrden; }
}
