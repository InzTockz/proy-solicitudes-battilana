package com.battilana.solicitud.pedidos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_usuarios_sap")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosSapEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_sap")
    private Long idUsuarioSap;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
