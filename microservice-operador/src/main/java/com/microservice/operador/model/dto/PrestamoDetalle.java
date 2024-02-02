package com.microservice.operador.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrestamoDetalle {
    private Long idprestamo;
    private int cantidad;
    private String fecha_prestamo;
    private String fecha_devolucion;
    private ClienteDTO cliente;
    private LibroDTO libro;
}
