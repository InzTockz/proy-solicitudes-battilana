package com.battilana.solicitud.pedidos.client.dto;

public record SapLoginRequest (
        String CompanyDB,
        String Password,
        String UserName
){
}
