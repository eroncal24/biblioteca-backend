package com.microservice.buscador.controller;

import com.microservice.buscador.model.Libro;
import com.microservice.buscador.service.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libro")
public class LibroController {

    @Autowired
    private LibroServiceImpl libroService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllLibro(){
        return ResponseEntity.ok(libroService.getAllLibro());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getByIdLibro(@PathVariable Long id){
        return ResponseEntity.ok(libroService.getByIdLibro(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLibro(@RequestBody Libro libro){
        libroService.createLibro(libro);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateLibro(@RequestBody Libro libro){
        libroService.updateLibro(libro);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> borrarProducto(@PathVariable Long id) {
        boolean borrado = libroService.removeLibro(id);
        return borrado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

//    @GetMapping("/search-by-autor/{idautor}")
//    public ResponseEntity<?> findByIdautor(@PathVariable Long idautor){
//        return ResponseEntity.ok(libroService.findByIdautor(idautor));
//    }
}
