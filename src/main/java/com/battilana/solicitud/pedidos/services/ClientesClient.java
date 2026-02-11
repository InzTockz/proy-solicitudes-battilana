package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.ClientesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "Clientes-Sap", url = "http://192.168.1.10:8081/api/v2/clientes")
//@FeignClient(name = "Clientes-Sap", url = "http://192.168.1.139:8082/api/v2/clientes")
public interface ClientesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/vendedor/{idVendedor}")
    List<ClientesResponse> listadoClientesPorIdVendedor(@PathVariable Integer idVendedor);

    @RequestMapping(method = RequestMethod.GET, value = "/vendedor/{idVendedor}/nombres")
    List<ClientesResponse> listadoClientesPorVendedorYCardName(@PathVariable Integer idVendedor, @RequestParam("cardName") String cardName);
}
