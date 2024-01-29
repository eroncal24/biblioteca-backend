package com.microservice.buscador.controller;

import com.microservice.buscador.model.Autor;
import com.microservice.buscador.model.Libro;
import com.microservice.buscador.service.AutorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buscador/autor")
public class AutorController {

    @Autowired
    private AutorServiceImpl autorService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllAutor(){
        return ResponseEntity.ok(autorService.getAllAutor());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getByIdAutor(@PathVariable Long id){
        return ResponseEntity.ok(autorService.getByIdAutor(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAutor(@RequestBody Autor autor){
        autorService.createAutor(autor);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateAutor(@RequestBody Autor autor){
        autorService.updateAutor(autor);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeAutor(@PathVariable Long id) {
        boolean borrado = autorService.removeAutor(id);
        return borrado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
