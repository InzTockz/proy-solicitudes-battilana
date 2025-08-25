package com.battilana.solicitud.pedidos.dtos;

public record UsuarioRequest(
        String names,
        String subnames,
        String email,
        String username,
        String password
) {

}
