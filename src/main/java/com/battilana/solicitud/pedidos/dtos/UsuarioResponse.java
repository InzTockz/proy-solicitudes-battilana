package com.battilana.solicitud.pedidos.dtos;

import com.battilana.solicitud.pedidos.entities.Roles;

import java.time.LocalDate;

public record UsuarioResponse(
        Long idUsuario,
        String names,
        String subnames,
        String email,
        LocalDate createAt,
        Boolean status,
        String username,
        String password,
        Roles roles
) {
}
