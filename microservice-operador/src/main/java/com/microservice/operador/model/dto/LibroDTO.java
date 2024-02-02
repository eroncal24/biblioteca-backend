package com.microservice.operador.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LibroDTO {
    private String codigo_isbn;
    private String nombre;
    private int anio_publicacion;
}
