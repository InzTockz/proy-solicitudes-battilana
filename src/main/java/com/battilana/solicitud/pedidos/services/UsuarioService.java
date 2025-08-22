package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.UsuarioRequest;
import com.battilana.solicitud.pedidos.dtos.UsuarioResponse;

import java.util.List;

public interface UsuarioService {

    List<UsuarioResponse> listUsers ();
    UsuarioResponse addUser (UsuarioRequest usuarioRequest);
    UsuarioResponse updateUser (Long idUsuario, UsuarioRequest usuarioRequest);
    UsuarioResponse findUsuario (Long idUsuario);
    void disableUser (Long idUsuario);
}
