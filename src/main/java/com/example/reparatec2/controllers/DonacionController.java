package com.example.reparatec2.controllers;

import com.example.reparatec2.dto.CreateDonacionRequest;
import com.example.reparatec2.models.Donacion;
import com.example.reparatec2.services.DonacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donaciones")
@CrossOrigin(origins = "*")
public class DonacionController {

    private final DonacionService donacionService;

    public DonacionController(DonacionService donacionService) {
        this.donacionService = donacionService;
    }

    @GetMapping
    public ResponseEntity<List<Donacion>> listar() {
        return ResponseEntity.ok(donacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donacion> obtenerPorId(@PathVariable int id) {
        return donacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Donacion> crear(@RequestBody CreateDonacionRequest request) {
        Donacion creada = donacionService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @GetMapping("/historial")
    public ResponseEntity<List<String>> obtenerHistorial() {
        return ResponseEntity.ok(donacionService.getHistorial());
    }
}
