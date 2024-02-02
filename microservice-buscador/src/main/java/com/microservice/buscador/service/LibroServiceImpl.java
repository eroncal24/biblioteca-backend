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
        return libroRepository.findAll();
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
    public Optional<Integer> getCantidadByIdLibro(Long idlibro) {
        if (!libroRepository.existsById(idlibro)) {
            return Optional.empty();
        }
        return Optional.of(libroRepository.findById(idlibro).get().getCantidad_disponible());
    }

    @Override
    public Optional<Libro> updateCantidadDispLibro(Long idlibro, int cantidad) {
        Optional<Libro> libro = libroRepository.findById(idlibro);
        if (libro.isPresent()) {
            libro.get().setCantidad_disponible(libro.get().getCantidad_disponible()+cantidad);
            return Optional.of(libroRepository.save(libro.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean removeLibro(Long idlibro) {
        if (!libroRepository.existsById(idlibro)) {
            return false;
        }
        libroRepository.deleteById(idlibro);
        return true;
    }

}
