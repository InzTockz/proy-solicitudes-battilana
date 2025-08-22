package com.battilana.solicitud.pedidos.mapper;

import com.battilana.solicitud.pedidos.dtos.UsuarioRequest;
import com.battilana.solicitud.pedidos.dtos.UsuarioResponse;
import com.battilana.solicitud.pedidos.entities.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuariosMapper {

    List<UsuarioResponse> toUserResponseList(List<UsuarioEntity> usuarioEntityList);

    UsuarioResponse toUserResponse (UsuarioEntity usuarioEntity);

    @InheritInverseConfiguration
    UsuarioEntity toUserEntity (UsuarioRequest usuarioRequest);
}
