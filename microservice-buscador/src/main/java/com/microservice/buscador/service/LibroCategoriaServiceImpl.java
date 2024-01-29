package com.microservice.buscador.service;

import com.microservice.buscador.model.LibroCategoria;
import com.microservice.buscador.repository.LibroCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroCategoriaServiceImpl implements LibroCategoriaService {

    @Autowired
    private LibroCategoriaRepository libroCategoriaRepository;

    @Override
    public List<LibroCategoria> getAllLibroCategoria() {
        return libroCategoriaRepository.findAll();
    }

    @Override
    public Optional<LibroCategoria> getByIdLibroCategoria(Long idlibrocategoria) {
        return libroCategoriaRepository.findById(idlibrocategoria);
    }

    @Override
    public LibroCategoria createLibroCategoria(LibroCategoria libroCategoria) {
        return libroCategoriaRepository.save(libroCategoria);
    }

    @Override
    public Optional<LibroCategoria> updateLibroCategoria(LibroCategoria libroCategoria) {
        if (!libroCategoriaRepository.existsById(libroCategoria.getIdlibrocategoria())) {
            return Optional.empty();
        }
        return Optional.of(libroCategoriaRepository.save(libroCategoria));
    }

    @Override
    public boolean removeLibroCategoria(Long idlibrocategoria) {
        if (!libroCategoriaRepository.existsById(idlibrocategoria)) {
            return false;
        }
        libroCategoriaRepository.deleteById(idlibrocategoria);
        return true;
    }
}
