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

    private final EquipoService service;

    public EquipoController(EquipoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Equipo> listarEquipos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerEquipo(@PathVariable int id) {
        return ResponseEntity.of(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Equipo> registrarEquipo(@RequestBody CreateEquipoRequest req) {
        boolean incompleto = req.marca() == null || req.modelo() == null || req.problemaReportado() == null;
        return incompleto
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.status(HttpStatus.CREATED).body(service.create(req));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Equipo> cambiarEstado(@PathVariable int id, @RequestBody Map<String, String> body) {
        String estado = body.get("estado");
        return (estado == null || estado.isBlank())
                ? ResponseEntity.badRequest().build()
                : ResponseEntity.of(service.updateEstado(id, estado));
    }
}