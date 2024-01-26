package com.microservice.buscador.persistence;

import com.microservice.buscador.entities.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends CrudRepository<Libro,Long> {
    List<Libro> findAllByIdautor(Long idautor);
}
