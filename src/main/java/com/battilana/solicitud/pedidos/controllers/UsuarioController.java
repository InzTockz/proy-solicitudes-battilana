package com.battilana.solicitud.pedidos.controllers;

import com.battilana.solicitud.pedidos.dtos.LoginRequest;
import com.battilana.solicitud.pedidos.dtos.LoginResponse;
import com.battilana.solicitud.pedidos.dtos.UsuarioRequest;
import com.battilana.solicitud.pedidos.dtos.UsuarioResponse;
import com.battilana.solicitud.pedidos.jwt.JwtGenerator;
import com.battilana.solicitud.pedidos.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin("*")
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
    ResponseEntity<UsuarioResponse> actualizarUsuario(@PathVariable Integer idUsuario, @RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.updateUser(idUsuario, usuarioRequest));
    }

    @GetMapping("/find/{idUsuario}")
    ResponseEntity<UsuarioResponse> buscarUsuario(@PathVariable Integer idUsuario){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.findUsuario(idUsuario));
    }

    @DeleteMapping("/disableUser/{idUsuario}")
    ResponseEntity<Void> deshabilitarUsuario(@PathVariable Integer idUsuario){
        this.usuarioService.disableUser(idUsuario);
        return ResponseEntity.noContent().build();
    }

    //SECCION DE LOGIN\
    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.login(loginRequest));
    }
}
