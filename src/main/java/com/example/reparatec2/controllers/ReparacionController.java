package com.example.reparatec2.controllers;

import com.example.reparatec2.dto.CreateReparacionRequest;
import com.example.reparatec2.models.Reparacion;
import com.example.reparatec2.services.ReparacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reparaciones")
@CrossOrigin(origins = "*")
public class ReparacionController {

    private final ReparacionService reparacionService;

    public ReparacionController(ReparacionService reparacionService) {
        this.reparacionService = reparacionService;
    }

    @GetMapping
    public ResponseEntity<List<Reparacion>> listar() {
        return ResponseEntity.ok(reparacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reparacion> obtenerPorId(@PathVariable int id) {
        return reparacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Reparacion> crear(@RequestBody CreateReparacionRequest request) {
        Reparacion creada = reparacionService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reparacion> actualizar(@PathVariable int id, @RequestBody CreateReparacionRequest request) {
        return reparacionService.update(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/historial")
    public ResponseEntity<List<String>> obtenerHistorial() {
        return ResponseEntity.ok(reparacionService.getHistorial());
    }
}
