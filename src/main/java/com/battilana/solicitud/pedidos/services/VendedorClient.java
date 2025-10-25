package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.VendedoresResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "VendedorSap", url = "http://localhost:8082/api/vendedores")
public interface VendedorClient {

    @RequestMapping(method = RequestMethod.GET, value="/{idVendedor}")
    VendedoresResponse buscarVendedorPorId(@PathVariable Integer idVendedor);
}
