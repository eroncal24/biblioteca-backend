package com.microservice.operador.service;

import com.microservice.operador.model.Cliente;
import com.microservice.operador.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getByIdCliente(Long idcliente) {
        return clienteRepository.findById(idcliente);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> updateCliente(Cliente cliente) {
        if (!clienteRepository.existsById(cliente.getIdcliente())) {
            return Optional.empty();
        }
        return Optional.of(clienteRepository.save(cliente));
    }

    @Override
    public boolean removeCliente(Long idcliente) {
        if (!clienteRepository.existsById(idcliente)) {
            return false;
        }
        clienteRepository.deleteById(idcliente);
        return true;
    }
}
