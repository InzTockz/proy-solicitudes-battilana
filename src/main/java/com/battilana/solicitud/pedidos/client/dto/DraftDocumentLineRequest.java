package com.battilana.solicitud.pedidos.client.dto;

public record DraftDocumentLineRequest (
        String ItemCode,
        String Quantity,
        String TaxCode,
        String UnitPrice
){
}
