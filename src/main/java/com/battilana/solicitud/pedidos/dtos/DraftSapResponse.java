package com.battilana.solicitud.pedidos.dtos;

import java.time.LocalDate;

public record DraftSapResponse(
        Integer docEntry,
        Integer docNum,
        String cardCode,
        String cardName,
        String objType,
        LocalDate docDate,
        Double docTotal,
        String docStatus,
        String canceled,
        String slpCode,
        LocalDate createDate,
        String wddStatus
) {
}
