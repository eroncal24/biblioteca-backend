package com.microservice.operador.service;

import com.microservice.operador.model.Prestamo;
import com.microservice.operador.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService{

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> getAllPrestamo() {
        return prestamoRepository.findAll();
    }

    @Override
    public Optional<Prestamo> getByIdPrestamo(Long idprestamo) {
        return prestamoRepository.findById(idprestamo);
    }

    @Override
    public Prestamo createPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Optional<Prestamo> updatePrestamo(Prestamo prestamo) {
        if (!prestamoRepository.existsById(prestamo.getIdprestamo())) {
            return Optional.empty();
        }
        return Optional.of(prestamoRepository.save(prestamo));
    }

    @Override
    public boolean removePrestamo(Long idprestamo) {
        if (!prestamoRepository.existsById(idprestamo)) {
            return false;
        }
        prestamoRepository.deleteById(idprestamo);
        return true;
    }
}
