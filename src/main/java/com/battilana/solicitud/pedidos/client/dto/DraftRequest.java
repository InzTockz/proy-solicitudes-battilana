package com.battilana.solicitud.pedidos.client.dto;

import java.util.List;

public record DraftRequest(
        String CardCode,
        String DocObjectCode,
        List<DraftDocumentLineRequest> draftDocumentLineRequests
) {
}
