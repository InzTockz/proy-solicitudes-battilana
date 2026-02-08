package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.DetalleDraftResponse;
import com.battilana.solicitud.pedidos.dtos.DraftSapResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "drafts-sap-client", url = "http://192.168.1.10:8081/api/borradores")
public interface DraftsSapClient {

    @RequestMapping(method = RequestMethod.GET, value = "/vendedor/{idVendedor}")
    List<DraftSapResponse> listadoDraftPorVendedorYFechas(
            @PathVariable Integer idVendedor,
            @RequestParam("fechaInicio") LocalDate fechaInicio,
            @RequestParam("fechaFin") LocalDate fechaFin
    );

    @RequestMapping(method = RequestMethod.GET, value = "/id/{docEntryId}")
    DraftSapResponse buscarDraftPorDocEntry(@PathVariable Integer docEntryId);

    @RequestMapping(method = RequestMethod.GET, value = "/detalle/{docEntryId}")
    List<DetalleDraftResponse> buscarDetalleDraftPorDocEntry(@PathVariable Integer docEntryId);
}
