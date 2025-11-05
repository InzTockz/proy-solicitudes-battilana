package com.battilana.solicitud.pedidos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @Column(name = "idUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "names", length = 150)
    private String names;

    @Column(name = "subnames", length = 150)
    private String subnames;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "createAt")
    @CreationTimestamp
    private LocalDate createAt;

    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "almacen")
    private String almacen;

    @Column(name = "status")
    private Boolean status = true;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private Roles roles = Roles.USUARIO;
}
