package com.example.reparatec2.services;

import com.example.reparatec2.dto.CreateRefaccionRequest;
import com.example.reparatec2.models.Refaccion;
import com.example.reparatec2.structures.CustomLinkedList;
import com.example.reparatec2.structures.CustomStack;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefaccionService {
    private final CustomLinkedList<Refaccion> refacciones = new CustomLinkedList<>();
    private final CustomStack<String> historialMovimientos = new CustomStack<>();
    private int nextId = 1;

    public RefaccionService() {
        // Datos de prueba iniciales
        refacciones.add(new Refaccion(nextId++, "Pantalla LCD iPhone", "Pantallas", 850.0, 12, "AppleTech"));
        refacciones.add(new Refaccion(nextId++, "Batería de Litio 3000mAh", "Baterías", 300.0, 25, "PowerCell"));
        historialMovimientos.push("Se cargaron refacciones iniciales al inventario");
    }

    public List<Refaccion> findAll() {
        return refacciones.toList();
    }

    public Optional<Refaccion> findById(int id) {
        return refacciones.toList().stream().filter(r -> r.getId() == id).findFirst();
    }

    public Refaccion create(CreateRefaccionRequest request) {
        Refaccion nueva = new Refaccion(
                nextId++,
                request.getNombre(),
                request.getCategoria(),
                request.getPrecioUnitario(),
                request.getStockDisponible(),
                request.getProveedor()
        );
        refacciones.add(nueva);
        historialMovimientos.push("Entrada: Se creó la refacción '" + nueva.getNombre() + "' con stock inicial de " + nueva.getStockDisponible());
        return nueva;
    }

    public Optional<Refaccion> updateStock(int id, int nuevoStock) {
        List<Refaccion> lista = refacciones.toList();
        Optional<Refaccion> encontrada = lista.stream().filter(r -> r.getId() == id).findFirst();

        if (encontrada.isPresent()) {
            Refaccion r = encontrada.get();
            int stockAnterior = r.getStockDisponible();
            r.setStockDisponible(nuevoStock);

            String tipoMovimiento = (nuevoStock > stockAnterior) ? "Entrada de piezas" : "Salida de piezas";
            historialMovimientos.push(tipoMovimiento + ": Refacción ID " + id + " (" + r.getNombre() + "). Stock anterior: " + stockAnterior + ", Nuevo stock: " + nuevoStock);

            return Optional.of(r);
        }
        return Optional.empty();
    }

    public List<String> getHistorial() {
        return historialMovimientos.toList();
    }
}
