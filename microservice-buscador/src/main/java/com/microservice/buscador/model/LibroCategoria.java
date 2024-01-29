package com.microservice.buscador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "libro_categorias")
@AllArgsConstructor
@NoArgsConstructor
public class LibroCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idlibrocategoria;
    private String descripcion;
    private boolean estado;
}
