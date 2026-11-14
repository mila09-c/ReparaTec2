package com.example.reparatec2.controllers;

import com.example.reparatec2.dto.CreateRefaccionRequest;
import com.example.reparatec2.models.Refaccion;
import com.example.reparatec2.services.RefaccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/refacciones")
@CrossOrigin(origins = "*")
public class RefaccionController {

    private final RefaccionService refaccionService;

    public RefaccionController(RefaccionService refaccionService) {
        this.refaccionService = refaccionService;
    }

    @GetMapping
    public ResponseEntity<List<Refaccion>> listar() {
        return ResponseEntity.ok(refaccionService.findAll());
    }

    @PostMapping
    public ResponseEntity<Refaccion> crear(@RequestBody CreateRefaccionRequest request) {
        Refaccion creada = refaccionService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Refaccion> actualizarStock(@PathVariable int id, @RequestBody Map<String, Integer> body) {
        int nuevoStock = body.getOrDefault("stockDisponible", 0);
        return refaccionService.updateStock(id, nuevoStock)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/historial")
    public ResponseEntity<List<String>> obtenerHistorial() {
        return ResponseEntity.ok(refaccionService.getHistorial());
    }
}
