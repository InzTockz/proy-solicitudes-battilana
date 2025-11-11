package com.battilana.solicitud.pedidos.dtos;

import java.util.List;

public record DraftResponse(
        Integer DocEntry,
        Integer DocNum,
        String DocObjectCode,
        String CardCode,
        String CardName,
        String DocDate,
        String DocCurrency,
        String SalesPersonCode,
        String DocTotal,
        String Comments,
        List<DraftDocumentLineRequest> DocumentLines
) {
}
