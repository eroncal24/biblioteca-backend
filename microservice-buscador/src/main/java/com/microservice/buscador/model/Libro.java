package com.microservice.buscador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "libros")
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idlibro;
    private String nombre;
    private String idautor;
    private int anio_publicacion;
    private String codigo_isbn;
    private String imagen_portada;
    private String sinopsis;
    private String criticas;
}
