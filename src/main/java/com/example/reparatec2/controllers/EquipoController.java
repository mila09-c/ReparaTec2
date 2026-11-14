package com.example.reparatec2.controllers;

import com.example.reparatec2.dto.CreateEquipoRequest;
import com.example.reparatec2.models.Equipo;
import com.example.reparatec2.services.EquipoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "*")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public ResponseEntity<List<Equipo>> listarEquipos() {
        return ResponseEntity.ok(equipoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerEquipo(@PathVariable int id) {
        return equipoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Equipo> registrarEquipo(@RequestBody CreateEquipoRequest request) {
        if (request.getMarca() == null || request.getModelo() == null || request.getProblemaReportado() == null) {
            return ResponseEntity.badRequest().build();
        }
        Equipo creado = equipoService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Equipo> cambiarEstado(@PathVariable int id, @RequestBody Map<String, String> body) {
        String nuevoEstado = body.get("estado");
        if (nuevoEstado == null || nuevoEstado.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        return equipoService.updateEstado(id, nuevoEstado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}