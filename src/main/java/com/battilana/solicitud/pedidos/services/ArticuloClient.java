package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.ArticulosResponse;
import com.battilana.solicitud.pedidos.dtos.StockAlmacenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "articulo-client", url = "http://localhost:8082/api/articulos")
public interface ArticuloClient {

    @RequestMapping(method = RequestMethod.GET, value = "/listar/{idAlmacen}")
    List<ArticulosResponse> listadoArticulosPorAlmacen(@PathVariable String idAlmacen);

    @RequestMapping(method = RequestMethod.GET, value = "/stock/articulo/{idArticulo}/almacen/{idAlmacen}")
    StockAlmacenResponse stockPorArticuloYAlmacenes(@PathVariable String idArticulo, @PathVariable String idAlmacen);

    @RequestMapping(method = RequestMethod.GET, value = "/listar-articulos/{idAlmacen}")
    List<ArticulosResponse> listadoArticulosPorAlmacenYNombre(@PathVariable String idAlmacen, @RequestParam("nombre") String nombre);
}
