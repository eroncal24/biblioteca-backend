package com.microservice.operador.service;

import com.microservice.operador.client.BuscadorClient;
import com.microservice.operador.model.Cliente;
import com.microservice.operador.model.Prestamo;
import com.microservice.operador.model.dto.ClienteDTO;
import com.microservice.operador.model.dto.LibroDTO;
import com.microservice.operador.model.dto.PrestamoDetalle;
import com.microservice.operador.repository.ClienteRepository;
import com.microservice.operador.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService{

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BuscadorClient buscadorClient;

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
        Optional<Integer> cant_disponible=buscadorClient.getCantidadByIdLibro(prestamo.getIdlibro());
        System.out.println("cant_disponible");
        System.out.println(cant_disponible);
        if (prestamo.getCantidad()<cant_disponible.get() && prestamo.getCantidad()>0) {
            Prestamo respuesta=prestamoRepository.save(prestamo);
            if(respuesta!=null){
                buscadorClient.updateCantidadDispLibro(respuesta.getIdlibro(), -respuesta.getCantidad());
            }
            return respuesta;
        }
        return null;
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

    @Override
    public PrestamoDetalle obtenerDetallePrestamo(Long idprestamo) {
        Optional<Prestamo> prestamo=prestamoRepository.findById(idprestamo);

        Optional<Cliente> cliente=clienteRepository.findById(prestamo.get().getIdcliente());

        ClienteDTO clienteDTO=new ClienteDTO();
        clienteDTO.setApellidos(cliente.get().getApellidos());
        clienteDTO.setNombres(cliente.get().getNombres());
        clienteDTO.setDni(cliente.get().getDni());

        LibroDTO libroDTO=buscadorClient.getByIdLibro(prestamo.get().getIdlibro());

        return PrestamoDetalle.builder()
                .idprestamo(prestamo.get().getIdprestamo())
                .cantidad(prestamo.get().getCantidad())
                .fecha_prestamo(prestamo.get().getFecha_prestamo())
                .fecha_devolucion(prestamo.get().getFecha_devolucion())
                .cliente(clienteDTO)
                .libro(libroDTO).build();
    }

    @Override
    public Optional<Prestamo> devolverLibroPrestamo(Long idprestamo) {
        Optional<Prestamo> prestamo=prestamoRepository.findById(idprestamo);
        if(prestamo.get().getEstado_prestamo()!="d"){
            prestamo.get().setEstado_prestamo("d");
            buscadorClient.updateCantidadDispLibro(prestamo.get().getIdlibro(), prestamo.get().getCantidad());
            return Optional.of(prestamoRepository.save(prestamo.get()));
        }
        return null;
    }
}
