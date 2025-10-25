package com.battilana.solicitud.pedidos.dtos;

public record DraftDocumentLineRequest (
        String ItemCode,
        String Quantity,
        String TaxCode,
        String UnitPrice
){
}
