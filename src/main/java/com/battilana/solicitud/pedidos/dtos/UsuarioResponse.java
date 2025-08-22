package com.battilana.solicitud.pedidos.dtos;

import java.time.LocalDate;

public record UsuarioResponse(
        String names,
        String subnames,
        String email,
        LocalDate createAt,
        Boolean status
) {
}
