package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.ClientesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "Clientes-Sap", url = "http://localhost:8082/api/clientes")
public interface ClientesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/listado/{idVendedor}")
    List<ClientesResponse> listadoClientesPorIdVendedor(@PathVariable Integer idVendedor);

    @RequestMapping(method = RequestMethod.GET, value = "/listado/vendedor/{idVendedor}")
    List<ClientesResponse> listadoClientesPorVendedorYCardName(@PathVariable Integer idVendedor, @RequestParam("cardName") String cardName);
}
