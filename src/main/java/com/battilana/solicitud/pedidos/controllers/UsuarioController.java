package com.battilana.solicitud.pedidos.controllers;

import com.battilana.solicitud.pedidos.dtos.UsuarioRequest;
import com.battilana.solicitud.pedidos.dtos.UsuarioResponse;
import com.battilana.solicitud.pedidos.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/list")
    ResponseEntity<List<UsuarioResponse>> listarUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.listUsers());
    }

    @PostMapping("/register")
    ResponseEntity<UsuarioResponse> registrarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.addUser(usuarioRequest));
    }

    @PutMapping("/update/{idUsuario}")
    ResponseEntity<UsuarioResponse> actualizarUsuario(@PathVariable Long idUsuario, @RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.updateUser(idUsuario, usuarioRequest));
    }

    @GetMapping("/find/{idUsuario}")
    ResponseEntity<UsuarioResponse> buscarUsuario(@PathVariable Long idUsuario){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.findUsuario(idUsuario));
    }

    @DeleteMapping("/disableUser/{idUsuario}")
    ResponseEntity<Void> deshabilitarUsuario(@PathVariable Long idUsuario){
        this.usuarioService.disableUser(idUsuario);
        return ResponseEntity.noContent().build();
    }
}
