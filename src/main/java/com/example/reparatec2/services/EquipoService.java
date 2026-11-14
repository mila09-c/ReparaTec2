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
        historial.push("Inicializados 2 equipos de prueba");
    }

    public List<Equipo> findAll() {
        return equipos.toList();
    }

    public Optional<Equipo> findById(int id) {
        return equipos.toList().stream().filter(e -> e.getId() == id).findFirst();
    }

    public Equipo create(CreateEquipoRequest request) {
        Equipo nuevo = new Equipo(
                nextId++,
                request.getTipo(),
                request.getMarca(),
                request.getModelo(),
                request.getNumeroSerie(),
                request.getProblemaReportado(),
                "Recibido",
                request.getUsuarioId()
        );
        equipos.add(nuevo);
        historial.push("Equipo registrado: " + nuevo.getMarca() + " " + nuevo.getModelo() + " (ID " + nuevo.getId() + ")");
        return nuevo;
    }

    public Optional<Equipo> updateEstado(int id, String nuevoEstado) {
        Optional<Equipo> encontrado = findById(id);
        encontrado.ifPresent(equipo -> {
            equipo.setEstado(nuevoEstado);
            historial.push("Equipo ID " + id + " cambio a estado: " + nuevoEstado);
        });
        return encontrado;
    }
}
