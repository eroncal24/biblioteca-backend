package com.microservice.buscador.service;

import com.microservice.buscador.entities.Libro;
import com.microservice.buscador.persistence.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements ILibroService{

    @Autowired
    private LibroRepository libroRepository;
    @Override
    public List<Libro> findAll() {
        return (List<Libro>) libroRepository.findAll();
    }

    @Override
    public Libro findById(Long idlibro) {
        return libroRepository.findById(idlibro).orElseThrow();
    }

    @Override
    public void save(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public List<Libro> findByIdAutor(Long idautor) {
        return libroRepository.findAllByIdautor(idautor);
    }
}
