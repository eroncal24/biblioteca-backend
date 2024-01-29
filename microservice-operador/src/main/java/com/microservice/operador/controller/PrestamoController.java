package com.microservice.operador.controller;

import com.microservice.operador.model.Prestamo;
import com.microservice.operador.service.PrestamoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/operador/prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoServiceImpl prestamoService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllPrestamo(){
        return ResponseEntity.ok(prestamoService.getAllPrestamo());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getByIdPrestamo(@PathVariable Long id){
        return ResponseEntity.ok(prestamoService.getByIdPrestamo(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPrestamo(@RequestBody Prestamo prestamo){
        prestamoService.createPrestamo(prestamo);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updatePrestamo(@RequestBody Prestamo prestamo){
        prestamoService.updatePrestamo(prestamo);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removePrestamo(@PathVariable Long id) {
        boolean borrado = prestamoService.removePrestamo(id);
        return borrado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
