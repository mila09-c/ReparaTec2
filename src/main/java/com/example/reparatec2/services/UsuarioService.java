package com.example.reparatec2.services;

import com.example.reparatec2.dto.CreateUsuarioRequest;
import com.example.reparatec2.models.Usuario;
import com.example.reparatec2.structures.CustomLinkedList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final CustomLinkedList<Usuario> usuarios = new CustomLinkedList<>();
    private int nextId = 1;

    public UsuarioService() {
        usuarios.add(new Usuario(nextId++, "Jessica Cuahutle", "jessica@reparatec.com", "Admin", "Activo"));
        usuarios.add(new Usuario(nextId++, "Mila Hernández", "mila@reparatec.com", "Técnico", "Activo"));
        usuarios.add(new Usuario(nextId++, "Carlos Pérez", "carlos@reparatec.com", "Cliente", "Activo"));
    }

    public List<Usuario> findAll() {
        return usuarios.toList();
    }

    public Optional<Usuario> findById(int id) {
        return usuarios.toList().stream().filter(u -> u.getId() == id).findFirst();
    }

    public Usuario create(CreateUsuarioRequest request) {
        String estado = (request.getEstado() == null || request.getEstado().isBlank()) ? "Activo" : request.getEstado();
        Usuario nuevo = new Usuario(nextId++, request.getNombre(), request.getCorreo(), request.getRol(), estado);
        usuarios.add(nuevo);
        return nuevo;
    }
}
