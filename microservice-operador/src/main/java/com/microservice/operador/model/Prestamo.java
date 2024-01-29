package com.microservice.operador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "prestamos")
@AllArgsConstructor
@NoArgsConstructor
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idprestamo;
    private int idcliente;
    private int idlibro;
    private int cantidad;
    private String fecha_prestamo;
    private String fecha_devolucion;
    private String observacion;
    private String estado_prestamo;
}
