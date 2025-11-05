package com.battilana.solicitud.pedidos.dtos;

public record LoginResponse(
        Long idUsuario,
        Integer codigo,
        String almacen,
        String token,
        String status
) {
}
