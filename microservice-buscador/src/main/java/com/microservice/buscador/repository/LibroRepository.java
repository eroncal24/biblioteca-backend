package com.microservice.buscador.repository;

import com.microservice.buscador.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends CrudRepository<Libro,Long> {
    //List<Libro> findAllByIdautor(Long idautor);
}
