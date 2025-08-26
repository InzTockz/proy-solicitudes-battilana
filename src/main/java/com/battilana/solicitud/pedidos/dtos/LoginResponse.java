package com.battilana.solicitud.pedidos.dtos;

public record LoginResponse(
        Long idUsuario,
        String names,
        String subnames,
        String token,
        String status
) {
}
