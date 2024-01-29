package com.microservice.buscador.service;

import com.microservice.buscador.model.Autor;

import java.util.List;
import java.util.Optional;

public interface AutorService {
    List<Autor> getAllAutor();
    Optional<Autor> getByIdAutor(Long idautor);
    Autor createAutor(Autor autor);
    Optional<Autor> updateAutor(Autor autor);
    boolean removeAutor(Long idautor);
}
