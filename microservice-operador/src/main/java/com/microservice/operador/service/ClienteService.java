package com.microservice.operador.service;

import com.microservice.operador.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> getAllCliente();
    Optional<Cliente> getByIdCliente(Long idcliente);
    Cliente createCliente(Cliente cliente);
    Optional<Cliente> updateCliente(Cliente cliente);
    boolean removeCliente(Long idcliente);
}
