package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.LoginRequest;
import com.battilana.solicitud.pedidos.dtos.LoginResponse;
import com.battilana.solicitud.pedidos.dtos.UsuarioRequest;
import com.battilana.solicitud.pedidos.dtos.UsuarioResponse;
import com.battilana.solicitud.pedidos.entities.AlmacenesEntity;

import java.util.List;

public interface UsuarioService {

    List<UsuarioResponse> listUsers ();
    UsuarioResponse addUser (UsuarioRequest usuarioRequest);
    UsuarioResponse updateUser (Integer idUsuario, UsuarioRequest usuarioRequest);
    UsuarioResponse findUsuario (Integer idUsuario);
    void disableUser (Integer idUsuario);
    List<AlmacenesEntity> findAlmacenesEntityByCodVendedor(Integer codVendedor);

    //LOGIN
    LoginResponse login (LoginRequest loginRequest);
}
