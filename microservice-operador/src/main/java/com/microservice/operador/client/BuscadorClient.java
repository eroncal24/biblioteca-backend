package com.microservice.operador.client;

import com.microservice.operador.model.dto.LibroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@FeignClient(name = "msvc-buscador", url = "localhost:8090/api/buscador/libro/")
public interface BuscadorClient {

    @GetMapping("/getById/{id}")
    LibroDTO getByIdLibro(@PathVariable Long id);

    @PutMapping("/updateCantidadDisp/{id}/{cant}")
    @ResponseStatus(HttpStatus.CREATED)
    void updateCantidadDispLibro(@PathVariable Long id, @PathVariable int cant);

    @GetMapping("/getCantidadById/{id}")
    Optional<Integer> getCantidadByIdLibro(@PathVariable Long id);
}
