package com.microservice.buscador.controller;

import com.microservice.buscador.entities.Libro;
import com.microservice.buscador.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libro")
public class LibroController {

    @Autowired
    private ILibroService libroService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLibro(@RequestBody Libro libro){
        libroService.save(libro);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllLibro(){
        return ResponseEntity.ok(libroService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(libroService.findById(id));
    }

    @GetMapping("/search-by-autor/{idautor}")
    public ResponseEntity<?> findByIdAutor(@PathVariable Long idautor){
        return ResponseEntity.ok(libroService.findById(idautor));
    }
}
