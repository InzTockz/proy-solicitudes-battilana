package com.battilana.solicitud.pedidos.dtos;

import java.util.List;

public record LoginResponse(
        Integer idUsuario,
        Integer codigo,
//        List<String> almacenes,
        String token,
        String status
) {
}
