package com.example.reparatec2.services;

import com.example.reparatec2.dto.CreateDonacionRequest;
import com.example.reparatec2.models.Donacion;
import com.example.reparatec2.structures.CustomLinkedList;
import com.example.reparatec2.structures.CustomStack;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonacionService {
    private final CustomLinkedList<Donacion> donaciones = new CustomLinkedList<>();
    private final CustomStack<String> historialMovimientos = new CustomStack<>();
    private int nextId = 1;

    public DonacionService() {
        // 3 registros de ejemplo iniciales (exigido por rúbrica)
        donaciones.add(new Donacion(nextId++, "Fundación TechForGood", "Laptop HP Core i5 (Usada)", "2026-11-01", "Recibido"));
        donaciones.add(new Donacion(nextId++, "Juan Pérez", "Tablet Lenovo Tab M10", "2026-11-05", "En Revisión"));
        donaciones.add(new Donacion(nextId++, "Empresa Innova S.A.", "Lotes de 5 fuentes de poder", "2026-11-10", "Aprobado"));
        historialMovimientos.push("Se inicializó el registro de donaciones con 3 elementos base.");
    }

    public List<Donacion> findAll() {
        return donaciones.toList();
    }

    public Optional<Donacion> findById(int id) {
        return donaciones.toList().stream().filter(d -> d.getId() == id).findFirst();
    }

    public Donacion create(CreateDonacionRequest request) {
        String estadoInicial = (request.getEstado() == null || request.getEstado().isBlank()) ? "Recibido" : request.getEstado();
        Donacion nueva = new Donacion(
                nextId++,
                request.getDonante(),
                request.getDescripcionEquipo(),
                request.getFecha(),
                estadoInicial
        );
        donaciones.add(nueva);
        historialMovimientos.push("Nueva donación registrada de: " + nueva.getDonante() + " (ID: " + nueva.getId() + ")");
        return nueva;
    }

    public List<String> getHistorial() {
        return historialMovimientos.toList();
    }
}
