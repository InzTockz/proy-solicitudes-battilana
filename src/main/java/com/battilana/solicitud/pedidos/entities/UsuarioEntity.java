package com.battilana.solicitud.pedidos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "names", length = 150)
    private String names;

    @Column(name = "subnames", length = 150)
    private String subnames;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", length = 9)
    private String phone;

    @Column(name = "date_created")
    @CreationTimestamp
    private LocalDate createAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "roles")
    private Roles roles = Roles.USUARIO;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "cod_vendedor")
    private Integer codVendedor;

    @Column(name = "sap_user_default")
    private Long usuarioSapPredeterminado;

    @Column(name = "status")
    private Boolean status = true;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<AlmacenesEntity> almacenes = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private TipoUsuario tipoUsuario;
}
