package com.microservice.buscador.service;

import com.microservice.buscador.model.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    List<Libro> getAllLibro();
    Optional<Libro> getByIdLibro(Long idlibro);
    Libro createLibro(Libro libro);
    Optional<Libro> updateLibro(Libro libro);
    Optional<Libro> updateCantidadDispLibro(Long idlibro, int cantidad);
    boolean removeLibro(Long idlibro);
}
