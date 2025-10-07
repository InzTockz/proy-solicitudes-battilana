package com.battilana.solicitud.pedidos.client.impl;

import com.battilana.solicitud.pedidos.client.SapLoginClient;
import com.battilana.solicitud.pedidos.client.dto.SapLoginRequest;
import com.battilana.solicitud.pedidos.client.dto.SapLoginResponse;
import org.springframework.stereotype.Service;

@Service
public class SapLoginClientImpl {

    private final SapLoginClient sapLoginClient;

    public SapLoginClientImpl(SapLoginClient sapLoginClient) {
        this.sapLoginClient = sapLoginClient;
    }


}
