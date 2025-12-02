package com.battilana.solicitud.pedidos.dtos;

public record ErrorResponse(
        String code,
        String message
) {
}
