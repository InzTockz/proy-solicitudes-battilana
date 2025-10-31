package com.battilana.solicitud.pedidos.dtos;

public record StockAlmacenResponse (
        double stock,
        double comprometido,
        double stockTotal,
        String unidadMedida,
        String codigoArticulo,
        String codigoAlmacen
){
}
