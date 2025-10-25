package com.battilana.solicitud.pedidos.dtos;

import java.util.List;

public record DraftRequest(
        String CardCode,
        String DocObjectCode,
        String Comments,
        String SalesPersonCode,
        List<DraftDocumentLineRequest> DocumentLines
) {
}
