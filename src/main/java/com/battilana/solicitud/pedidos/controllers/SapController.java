package com.battilana.solicitud.pedidos.controllers;

import com.battilana.solicitud.pedidos.dtos.*;
import com.battilana.solicitud.pedidos.services.DraftsClient;
import com.battilana.solicitud.pedidos.services.ManageSapService;
import com.battilana.solicitud.pedidos.services.SapLoginClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sap")
@CrossOrigin("*")
public class SapController {

    private final ManageSapService manageSapService;

    public SapController(ManageSapService manageSapService) {
        this.manageSapService = manageSapService;
    }

    @PostMapping("/agregar/user-sap/{idUsuarioSap}")
    public ResponseEntity<DraftResponse> agregarDraft(@RequestBody DraftRequest draftRequest,@PathVariable Long idUsuarioSap){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.manageSapService.saveDraft(draftRequest, idUsuarioSap));
    }

    @GetMapping("/listado/idDraft/{idDraft}/idUserSap/{idUserSap}")
    public ResponseEntity<DraftResponse> listadoDrafts(@PathVariable Integer idDraft, @PathVariable Long idUserSap) {
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.findDraftById(idDraft, idUserSap));
    }

    @GetMapping("/listado/clientes/{idVendedor}")
    public ResponseEntity<List<ClientesResponse>> listarClientesPorVendedor(@PathVariable Integer idVendedor){
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.listadoClientesPorVendedor(idVendedor));
    }

    @GetMapping("/listado/vendedor/{idVendedor}")
    public ResponseEntity<VendedoresResponse> buscarVendedorPorId(@PathVariable Integer idVendedor){
        return ResponseEntity.status(HttpStatus.OK).body(this.manageSapService.buscarVendedorPorId(idVendedor));
    }
}
