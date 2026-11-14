package com.example.reparatec2.dto;

public class CreateReparacionRequest {
    private int equipoId;
    private String tecnicoAsignado;
    private String diagnostico;
    private double costoEstimado;
    private String fechaIngreso;
    private String estadoOrden;

    // Getters y Setters
    public int getEquipoId() { return equipoId; }
    public void setEquipoId(int equipoId) { this.equipoId = equipoId; }

    public String getTecnicoAsignado() { return tecnicoAsignado; }
    public void setTecnicoAsignado(String tecnicoAsignado) { this.tecnicoAsignado = tecnicoAsignado; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public double getCostoEstimado() { return costoEstimado; }
    public void setCostoEstimado(double costoEstimado) { this.costoEstimado = costoEstimado; }

    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public String getEstadoOrden() { return estadoOrden; }
    public void setEstadoOrden(String estadoOrden) { this.estadoOrden = estadoOrden; }
}
