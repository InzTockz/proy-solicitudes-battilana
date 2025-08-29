package com.battilana.solicitud.pedidos.client;

import com.battilana.solicitud.pedidos.client.dto.SapLoginRequest;
import com.battilana.solicitud.pedidos.client.dto.SapLoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "login-sap", url = "https://192.168.1.2:50000")
public interface SapLoginClient {

    @PostMapping("/b1s/v2/Login")
    SapLoginResponse sapLogin(@RequestBody SapLoginRequest sapLoginRequest);
}
