package com.microservice.buscador.service;

import com.microservice.buscador.entities.Libro;

import java.util.List;

public interface ILibroService {
    List<Libro> findAll();

    Libro findById(Long idlibro);

    void save(Libro libro);

    List<Libro> findByIdAutor(Long idautor);
}
