package com.battilana.solicitud.pedidos.client.impl;

import com.battilana.solicitud.pedidos.client.SapLoginClient;
import com.battilana.solicitud.pedidos.client.dto.SapLoginRequest;
import com.battilana.solicitud.pedidos.client.dto.SapLoginResponse;
import org.springframework.stereotype.Service;

@Service
public class SapLoginClientImplk {

    private SapLoginClient sapLoginClient;

    public SapLoginResponse getSapLoginClient(SapLoginRequest sapLoginRequest){
        return this.sapLoginClient.sapLogin(sapLoginRequest);
    }
}
