package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.VendedoresResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "VendedorSap", url = "http://192.168.1.10:8081/api/v2/vendedores")
//@FeignClient(name = "VendedorSap", url = "http://192.168.1.139:8082/api/v2/vendedores")
public interface VendedorClient {

    @RequestMapping(method = RequestMethod.GET, value="/{slpCode}")
    VendedoresResponse buscarVendedorPorId(@PathVariable Integer slpCode);
}
