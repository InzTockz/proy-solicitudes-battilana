package com.battilana.solicitud.pedidos.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

public record SapLoginRequest(
    @JsonProperty("CompanyDB") String CompanyDB,
    @JsonProperty("Password") String Password,
    @JsonProperty("UserName") String UserName
){}

