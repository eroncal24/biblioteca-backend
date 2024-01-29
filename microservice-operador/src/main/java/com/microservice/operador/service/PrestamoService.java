package com.microservice.operador.service;

import com.microservice.operador.model.Cliente;
import com.microservice.operador.model.Prestamo;

import java.util.List;
import java.util.Optional;

public interface PrestamoService {
    List<Prestamo> getAllPrestamo();
    Optional<Prestamo> getByIdPrestamo(Long idprestamo);
    Prestamo createPrestamo(Prestamo prestamo);
    Optional<Prestamo> updatePrestamo(Prestamo prestamo);
    boolean removePrestamo(Long idprestamo);
}