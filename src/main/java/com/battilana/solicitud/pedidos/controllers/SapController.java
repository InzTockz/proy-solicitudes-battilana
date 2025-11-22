package com.battilana.solicitud.pedidos.controllers;

import com.battilana.solicitud.pedidos.dtos.*;
import com.battilana.solicitud.pedidos.services.DraftsClient;
import com.battilana.solicitud.pedidos.services.DraftsSapClient;
import com.battilana.solicitud.pedidos.services.ManageSapService;
import com.battilana.solicitud.pedidos.services.SapLoginClient;
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

    public SapController(ManageSapService manageSapService, DraftsSapClient draftsSapClient) {
        this.manageSapService = manageSapService;
        this.draftsSapClient = draftsSapClient;
    }

    @PostMapping("/agregar/user-sap/{idUsuarioSap}")
    public ResponseEntity<DraftResponse> agregarDraft(@RequestBody DraftRequest draftRequest,@PathVariable Long idUsuarioSap){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.manageSapService.saveDraft(draftRequest, idUsuarioSap));
    }

    @GetMapping("/listado/idDraft/{idDraft}/idUserSap/{idUserSap}")
    public ResponseEntity<DraftResponse> listadoDrafts(@PathVariable Integer idDraft, @PathVariable Long idUserSap) {
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.findDraftById(idDraft, idUserSap));
    }

    //LISTADO DE CLIENTES POR VENDEDOR
    @GetMapping("/listado/clientes/{idVendedor}")
    public ResponseEntity<List<ClientesResponse>> listarClientesPorVendedor(@PathVariable Integer idVendedor){
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.listadoClientesPorVendedor(idVendedor));
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

    //LISTAR STOCK POR PRODUCTO Y ALMACEN
    @GetMapping("/stock/articulo/{idArticulo}/almacen/{idAlmacen}")
    public ResponseEntity<StockAlmacenResponse> stockPorProductoYAlmacen(@PathVariable String idArticulo, @PathVariable String idAlmacen){
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.stockPorArticuloYAlmacen(idArticulo, idAlmacen));
    }

    //LISTADO DE DRAFTS POR VENDEDOR
    @GetMapping("/listar-draft/{idVendedor}")
    public ResponseEntity<List<DraftSapResponse>> listadoDraftsPorVendedorYFecha(@PathVariable Integer idVendedor, @RequestParam("fechaInicio") LocalDate fechaInicio, @RequestParam("fechaFin") LocalDate fechaFin){
        return ResponseEntity.status(HttpStatus.OK).body(this.draftsSapClient.listadoDraftPorVendedorYFechas(idVendedor, fechaInicio, fechaFin));
    }
}
