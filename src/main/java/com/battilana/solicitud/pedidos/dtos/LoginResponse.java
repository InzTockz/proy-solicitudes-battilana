package com.battilana.solicitud.pedidos.dtos;

public record LoginResponse(
        Long idUsuario,
        String names,
        String subnames,
        Integer codigo,
        String almacen,
        String token,
        String status
) {
}
