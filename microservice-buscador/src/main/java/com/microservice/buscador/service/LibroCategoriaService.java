package com.microservice.buscador.service;

import com.microservice.buscador.model.Libro;
import com.microservice.buscador.model.LibroCategoria;

import java.util.List;
import java.util.Optional;

public interface LibroCategoriaService {
    List<LibroCategoria> getAllLibroCategoria();
    Optional<LibroCategoria> getByIdLibroCategoria(Long idlibrocategoria);
    LibroCategoria createLibroCategoria(LibroCategoria libroCategoria);
    Optional<LibroCategoria> updateLibroCategoria(LibroCategoria libroCategoria);
    boolean removeLibroCategoria(Long idlibrocategoria);
}
