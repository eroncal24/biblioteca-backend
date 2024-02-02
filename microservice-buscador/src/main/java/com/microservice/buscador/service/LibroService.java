package com.microservice.buscador.service;

import com.microservice.buscador.model.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    List<Libro> getAllLibro();
    Optional<Libro> getByIdLibro(Long idlibro);
    Libro createLibro(Libro libro);
    Optional<Libro> updateLibro(Libro libro);
    Optional<Integer> getCantidadByIdLibro(Long idlibro);
    Optional<Libro> updateCantidadDispLibro(Long idlibro, int cantidad_disponible);
    boolean removeLibro(Long idlibro);
}
