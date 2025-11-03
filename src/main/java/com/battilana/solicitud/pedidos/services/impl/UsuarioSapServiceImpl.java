package com.battilana.solicitud.pedidos.services.impl;

import com.battilana.solicitud.pedidos.dtos.UsuarioResponse;
import com.battilana.solicitud.pedidos.dtos.UsuarioSapResponse;
import com.battilana.solicitud.pedidos.entities.UsuariosSapEntity;
import com.battilana.solicitud.pedidos.repositorys.UsuarioSapRepository;
import com.battilana.solicitud.pedidos.services.UsuarioSapService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioSapServiceImpl implements UsuarioSapService {

    private final UsuarioSapRepository usuarioSapRepository;

    public UsuarioSapServiceImpl(UsuarioSapRepository usuarioSapRepository) {
        this.usuarioSapRepository = usuarioSapRepository;
    }

    @Override
    public List<UsuarioSapResponse> findAllUsuariosSap() {
        List<UsuariosSapEntity> usuariosSapEntityList = this.usuarioSapRepository.findAll();
        List<UsuarioSapResponse> usuarioSapResponses = new ArrayList<>();
        for (UsuariosSapEntity usuariosSapEntity : usuariosSapEntityList){
            usuarioSapResponses.add(new UsuarioSapResponse(
                    usuariosSapEntity.getIdUsuarioSap(), usuariosSapEntity.getNombreUsuario()
            ));
        }
        return usuarioSapResponses;
    }
}
