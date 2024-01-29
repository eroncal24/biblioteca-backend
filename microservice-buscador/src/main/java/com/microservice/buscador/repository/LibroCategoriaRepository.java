package com.microservice.buscador.repository;

import com.microservice.buscador.model.LibroCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroCategoriaRepository extends JpaRepository<LibroCategoria,Long> {
}
