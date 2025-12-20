package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.*;
import com.battilana.solicitud.pedidos.entities.AlmacenesEntity;

import java.util.List;

public interface UsuarioService {

    List<UsuarioResponse> listUsers ();
    UsuarioResponse addUser (UsuarioRequest usuarioRequest);
    UsuarioResponse updateUser (Integer idUsuario, UsuarioRequest usuarioRequest);
    UsuarioResponse findUsuario (Integer idUsuario);
    void disableUser (Integer idUsuario);
    List<AlmacenResponse> findAlmacenesEntityByCodVendedor(Integer codVendedor);

    //LOGIN
    LoginResponse login (LoginRequest loginRequest);
}
