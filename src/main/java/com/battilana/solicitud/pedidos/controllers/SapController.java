package com.battilana.solicitud.pedidos.controllers;

import com.battilana.solicitud.pedidos.dtos.*;
import com.battilana.solicitud.pedidos.services.DraftsSapClient;
import com.battilana.solicitud.pedidos.services.ManageSapService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sap")
@CrossOrigin("*")
public class SapController {

    private final ManageSapService manageSapService;
    private final DraftsSapClient draftsSapClient;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public SapController(ManageSapService manageSapService, DraftsSapClient draftsSapClient) {
        this.manageSapService = manageSapService;
        this.draftsSapClient = draftsSapClient;
    }

    @PostMapping("/agregar/user-sap/{idUsuarioSap}")
    public ResponseEntity<?> agregarDraft(@RequestBody DraftSLRequest draftSLRequest, @PathVariable Long idUsuarioSap){
        try {
            DraftSLResponse respuesta = this.manageSapService.saveDraft(draftSLRequest, idUsuarioSap);

            if(respuesta == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ErrorResponse("message", "Usuario Sap no Encontrado"));
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
        } catch (FeignException e){
            String body = e.contentUTF8();
            String sapCode = "UNKNOWN";
            try {
                JsonNode root = objectMapper.readTree(body);
                sapCode = root.path("error").path("code").asText("UNKKOWN");
            } catch (Exception ignore){}

            String userMessage = "Ocurrió un error en SAP";

            if(sapCode.equals("-10")){
                userMessage = "Actualizar tipo de cambio";
            }

            ErrorResponse errorResponse = new ErrorResponse(sapCode, userMessage);

            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @GetMapping("/listado/idDraft/{idDraft}/idUserSap/{idUserSap}")
    public ResponseEntity<DraftSLResponse> listadoDrafts(@PathVariable Integer idDraft, @PathVariable Long idUserSap) {
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.findDraftById(idDraft, idUserSap));
    }

    //LISTADO DE CLIENTES POR VENDEDOR
    @GetMapping("/listado/clientes/{idVendedor}")
    public ResponseEntity<List<ClientesResponse>> listarClientesPorVendedor(@PathVariable Integer idVendedor){
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.listadoClientesPorVendedor(idVendedor));
    }

    @GetMapping("/listar-clientes/vendedor/{idVendedor}")
    public ResponseEntity<List<ClientesResponse>> listarClientesPorVendedorYCardName(@PathVariable Integer idVendedor, @RequestParam("cardName") String cardName){
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.listadoClientesPorVendedorYCardName(idVendedor, cardName));
    }

    @GetMapping("/listado/vendedor/{idVendedor}")
    public ResponseEntity<VendedoresResponse> buscarVendedorPorId(@PathVariable Integer idVendedor){
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.buscarVendedorPorId(idVendedor));
    }

    //LISTAR ARTICULOS POR ALMACEN
    @GetMapping("/listado/articulos/{idAlmacen}")
    public ResponseEntity<List<ArticulosResponse>> listadoArticulosPorAlmacen(@PathVariable String idAlmacen){
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.listadoArticulosPorAlmacen(idAlmacen));
    }
    @GetMapping("/listar-articulos/{idAlmacen}")
    public ResponseEntity<List<ArticulosResponse>> listadoArticulosPorAlmacenYNombre(@PathVariable String idAlmacen, @RequestParam("nombre") String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.listadoArticulosPorAlmacenYNombre(idAlmacen, nombre));
    }

    //LISTAR STOCK POR PRODUCTO Y ALMACENES
    @GetMapping("/stock/articulo/{idArticulo}/vendedor/{idAlmacen}")
    public ResponseEntity<StockAlmacenResponse> stockPorProductoYAlmacen(@PathVariable String idArticulo, @PathVariable String idAlmacen){
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.stockPorArticuloYAlmacen(idArticulo, idAlmacen));
    }

    //LISTADO DE DRAFTS POR VENDEDOR
    @GetMapping("/listar-draft/{idVendedor}")
    public ResponseEntity<List<DraftSapResponse>> listadoDraftsPorVendedorYFecha(@PathVariable Integer idVendedor, @RequestParam(value = "fechaInicio", required = false) LocalDate fechaInicio, @RequestParam(value = "fechaFin", required = false) LocalDate fechaFin){
        return ResponseEntity.status(HttpStatus.OK).body(this.draftsSapClient.listadoDraftPorVendedorYFechas(idVendedor, fechaInicio, fechaFin));
    }

    @GetMapping("/buscar-draft/docEntryId/{docEntryId}")
    public ResponseEntity<DraftSapResponse> buscarDraftPorDocEntry(@PathVariable Integer docEntryId){
        return ResponseEntity.status(HttpStatus.OK).body(this.draftsSapClient.buscarDraftPorDocEntry(docEntryId));
    }

    @GetMapping("/buscar-detalle-draft/docEntryId/{docEntryId}")
    public ResponseEntity<List<DetalleDraftResponse>> buscarDetalleDraftPorDocEntry(@PathVariable Integer docEntryId){
        return ResponseEntity.status(HttpStatus.OK).body(this.draftsSapClient.buscarDetalleDraftPorDocEntry(docEntryId));
    }
}
