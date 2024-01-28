package com.microservice.buscador.service;

import com.microservice.buscador.model.Libro;
import com.microservice.buscador.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;
    @Override
    public List<Libro> getAllLibro() {
        return (List<Libro>) libroRepository.findAll();
    }

    @Override
    public Optional<Libro> getByIdLibro(Long idlibro) {
        return libroRepository.findById(idlibro);
    }

    @Override
    public Libro createLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Optional<Libro> updateLibro(Libro libro) {
        if (!libroRepository.existsById(libro.getIdlibro())) {
            return Optional.empty();
        }
        return Optional.of(libroRepository.save(libro));
    }

    @Override
    public boolean removeLibro(Long idlibro) {
        if (!libroRepository.existsById(idlibro)) {
            return false;
        }

        libroRepository.deleteById(idlibro);
        return true;
    }


//    @Autowired
//    private LibroRepository libroRepository;
//    @Override
//    public List<Libro> findAll() {
//        return (List<Libro>) libroRepository.findAll();
//    }
//
//    @Override
//    public Libro findById(Long idlibro) {
//        return libroRepository.findById(idlibro).orElseThrow();
//    }
//
//    @Override
//    public void save(Libro libro) {
//        libroRepository.save(libro);
//    }
//
//    @Override
//    public List<Libro> findByIdautor(Long idautor) {
//        return libroRepository.findAllByIdautor(idautor);
//    }
}
