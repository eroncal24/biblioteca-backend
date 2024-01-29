package com.microservice.operador.controller;

import com.microservice.operador.model.Cliente;
import com.microservice.operador.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/operador/cliente")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCliente(){
        return ResponseEntity.ok(clienteService.getAllCliente());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getByIdCliente(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.getByIdCliente(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCliente(@RequestBody Cliente cliente){
        clienteService.createCliente(cliente);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateCliente(@RequestBody Cliente cliente){
        clienteService.updateCliente(cliente);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeCliente(@PathVariable Long id) {
        boolean borrado = clienteService.removeCliente(id);
        return borrado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
