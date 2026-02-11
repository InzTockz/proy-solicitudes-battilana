package com.battilana.solicitud.pedidos.dtos;

import java.time.LocalDate;

public record DraftSapResponse(
        Integer docEntry,
        String objType,
        LocalDate docDate,
        LocalDate createDate,
        String cardCode,
        String cardName,
        Integer slpCode,
        String fullNamesSlp,
        Integer ownerCode,
        String fullNamesOwner,
        String wddStatus,
        String comments,
        String docCur,
        Double docTotal
) {
}
