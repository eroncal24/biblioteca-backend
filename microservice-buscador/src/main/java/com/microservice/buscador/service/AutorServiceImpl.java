package com.microservice.buscador.service;

import com.microservice.buscador.model.Autor;
import com.microservice.buscador.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;
    @Override
    public List<Autor> getAllAutor() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> getByIdAutor(Long idautor) {
        return autorRepository.findById(idautor);
    }

    @Override
    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Optional<Autor> updateAutor(Autor autor) {
        if (!autorRepository.existsById(autor.getIdautor())) {
            return Optional.empty();
        }
        return Optional.of(autorRepository.save(autor));
    }

    @Override
    public boolean removeAutor(Long idautor) {
        if (!autorRepository.existsById(idautor)) {
            return false;
        }
        autorRepository.deleteById(idautor);
        return true;
    }
}
