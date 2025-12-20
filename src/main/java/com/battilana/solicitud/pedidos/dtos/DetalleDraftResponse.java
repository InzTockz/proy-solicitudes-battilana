package com.battilana.solicitud.pedidos.dtos;

public record DetalleDraftResponse(
        Integer lineNum,
        String itemCode,
        String description,
        Double quantity,
        String uomCode,
        String whsCode,
        Integer docEntry
) {
}
