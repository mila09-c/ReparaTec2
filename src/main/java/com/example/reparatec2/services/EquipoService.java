package com.example.reparatec2.services;

import com.example.reparatec2.dto.CreateEquipoRequest;
import com.example.reparatec2.models.Equipo;
import com.example.reparatec2.structures.CustomLinkedList;
import com.example.reparatec2.structures.CustomStack;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    private final CustomLinkedList<Equipo> equipos = new CustomLinkedList<>();
    private final CustomStack<String> historial = new CustomStack<>();
    private int nextId = 1;

    public EquipoService() {
        equipos.add(new Equipo(nextId++, "Laptop", "HP", "Pavilion 15", "SN-HP-001",
                "No enciende y pantalla parpadea", "Recibido", 1));
        equipos.add(new Equipo(nextId++, "PC Escritorio", "Dell", "OptiPlex 7090", "SN-DL-002",
                "Sobrecalentamiento y ruido en ventilador", "En revision", 2));
        equipos.add(new Equipo(nextId++, "Impresora", "Epson", "EcoTank L3250", "SN-EP-003",
                "Atasco continuo de papel en bandeja", "Reparado", 1));
        historial.push("Inicializados 3 equipos de prueba");
    }

    public List<Equipo> findAll() {
        return equipos.toList();
    }

    public Optional<Equipo> findById(int id) {
        return equipos.toList().stream().filter(e -> e.getId() == id).findFirst();
    }

    public Equipo create(CreateEquipoRequest req) {
        Equipo nuevo = new Equipo(nextId++, req.tipo(), req.marca(), req.modelo(),
                req.numeroSerie(), req.problemaReportado(), "Recibido", req.usuarioId());
        equipos.add(nuevo);
        historial.push("Alta equipo ID " + nuevo.getId() + ": " + nuevo.getMarca() + " " + nuevo.getModelo());
        return nuevo;
    }

    public Optional<Equipo> updateEstado(int id, String nuevoEstado) {
        Optional<Equipo> encontrado = findById(id);
        encontrado.ifPresent(equipo -> {
            equipo.setEstado(nuevoEstado);
            historial.push("Cambio estado equipo ID " + id + " -> " + nuevoEstado);
        });
        return encontrado;
    }
}