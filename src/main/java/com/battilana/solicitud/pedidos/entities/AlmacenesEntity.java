package com.battilana.solicitud.pedidos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_almacenes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlmacenesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlmacen;

    @Column(length = 2)
    private String codigo;
    private String descripcion;
}
