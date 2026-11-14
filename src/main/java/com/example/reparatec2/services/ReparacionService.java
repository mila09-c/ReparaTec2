package com.example.reparatec2.services;

import com.example.reparatec2.dto.CreateReparacionRequest;
import com.example.reparatec2.models.Reparacion;
import com.example.reparatec2.structures.CustomLinkedList;
import com.example.reparatec2.structures.CustomStack;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReparacionService {
    private final CustomLinkedList<Reparacion> reparaciones = new CustomLinkedList<>();
    private final CustomStack<String> historialMovimientos = new CustomStack<>();
    private int nextId = 1;

    public ReparacionService() {
        // Datos de prueba iniciales
        reparaciones.add(new Reparacion(nextId++, 1, "Mila Hernández", "Cambio de pantalla", 1500.0, "2026-11-10", "En Proceso"));
        historialMovimientos.push("Se inicializó la orden ID: 1");
    }

    public List<Reparacion> findAll() {
        return reparaciones.toList();
    }

    public Optional<Reparacion> findById(int id) {
        return reparaciones.toList().stream().filter(r -> r.getId() == id).findFirst();
    }

    public Reparacion create(CreateReparacionRequest request) {
        String estado = (request.getEstadoOrden() == null || request.getEstadoOrden().isBlank()) ? "Recibido" : request.getEstadoOrden();
        Reparacion nueva = new Reparacion(
                nextId++,
                request.getEquipoId(),
                request.getTecnicoAsignado(),
                request.getDiagnostico(),
                request.getCostoEstimado(),
                request.getFechaIngreso(),
                estado
        );
        reparaciones.add(nueva);
        historialMovimientos.push("Se creó la orden de reparación ID: " + nueva.getId());
        return nueva;
    }

    public Optional<Reparacion> update(int id, CreateReparacionRequest request) {
        List<Reparacion> lista = reparaciones.toList();
        Optional<Reparacion> encontrada = lista.stream().filter(r -> r.getId() == id).findFirst();

        if (encontrada.isPresent()) {
            Reparacion r = encontrada.get();
            r.setEquipoId(request.getEquipoId());
            r.setTecnicoAsignado(request.getTecnicoAsignado());
            r.setDiagnostico(request.getDiagnostico());
            r.setCostoEstimado(request.getCostoEstimado());
            r.setFechaIngreso(request.getFechaIngreso());
            r.setEstadoOrden(request.getEstadoOrden());

            historialMovimientos.push("Se actualizó la orden de reparación ID: " + id);
            return Optional.of(r);
        }
        return Optional.empty();
    }

    public List<String> getHistorial() {
        return historialMovimientos.toList();
    }
}
