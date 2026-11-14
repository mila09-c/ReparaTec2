package com.example.reparatec2.dto;

public record CreateEquipoRequest(
        String tipo,
        String marca,
        String modelo,
        String numeroSerie,
        String problemaReportado,
        int usuarioId
) {}