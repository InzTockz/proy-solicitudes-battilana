package com.battilana.solicitud.pedidos.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SapLoginResponse (

//        @JsonProperty("@odata.context")
//        String oDataContext,
        String SessionId,
        String Version,
        Integer SessionTimeout
){
}
