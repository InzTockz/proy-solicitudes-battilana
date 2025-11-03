package com.battilana.solicitud.pedidos.controllers;

import com.battilana.solicitud.pedidos.dtos.UsuarioSapResponse;
import com.battilana.solicitud.pedidos.services.UsuarioSapService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario-sap")
@CrossOrigin("*")
public class UsuarioSapController {

    private final UsuarioSapService usuarioSapService;

    public UsuarioSapController(UsuarioSapService usuarioSapService) {
        this.usuarioSapService = usuarioSapService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioSapResponse>> listarUsuariosSap(){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioSapService.findAllUsuariosSap());
    }
}
