package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.SapLoginRequest;
import com.battilana.solicitud.pedidos.dtos.SapLoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "login-sap", url = "https://192.168.1.2:50000/b1s/v2")
public interface SapLoginClient {

    @PostMapping("/Login")
    ResponseEntity<SapLoginResponse> sapLogin(@RequestBody SapLoginRequest sapLoginRequest);
}
