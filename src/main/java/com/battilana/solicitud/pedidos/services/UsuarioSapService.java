package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.UsuarioSapResponse;

import java.util.List;

public interface UsuarioSapService {
    List<UsuarioSapResponse> findAllUsuariosSap();
}
