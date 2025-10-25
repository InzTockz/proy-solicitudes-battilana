package com.battilana.solicitud.pedidos.dtos;

public record ClientesResponse (
        String cardCode,
        String cardName,
        String email,
        String licTradNum
){
}
