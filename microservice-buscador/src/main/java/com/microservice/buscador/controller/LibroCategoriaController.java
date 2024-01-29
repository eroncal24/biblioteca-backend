package com.microservice.buscador.controller;

import com.microservice.buscador.model.LibroCategoria;
import com.microservice.buscador.service.LibroCategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buscador/librocategoria")
public class LibroCategoriaController {

    @Autowired
    private LibroCategoriaServiceImpl libroCategoriaService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllLibroCategoria(){
        return ResponseEntity.ok(libroCategoriaService.getAllLibroCategoria());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getByIdLibroCategoria(@PathVariable Long id){
        return ResponseEntity.ok(libroCategoriaService.getByIdLibroCategoria(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLibroCategoria(@RequestBody LibroCategoria libroCategoria){
        libroCategoriaService.createLibroCategoria(libroCategoria);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateLibroCategoria(@RequestBody LibroCategoria libroCategoria){
        libroCategoriaService.updateLibroCategoria(libroCategoria);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeLibroCategoria(@PathVariable Long id) {
        boolean borrado = libroCategoriaService.removeLibroCategoria(id);
        return borrado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
