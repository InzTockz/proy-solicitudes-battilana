package com.battilana.solicitud.pedidos.mapper;

import com.battilana.solicitud.pedidos.dtos.AlmacenResponse;
import com.battilana.solicitud.pedidos.entities.AlmacenesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlmacenesMapper {

    List<AlmacenResponse> toAlmacenResponseList(List<AlmacenesEntity> almacenesEntities);

    AlmacenResponse toAlmacenResponse(AlmacenesEntity almacenesEntity);
}
