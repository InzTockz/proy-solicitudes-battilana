package com.battilana.solicitud.pedidos.mapper;

import com.battilana.solicitud.pedidos.dtos.AlmacenResponse;
import com.battilana.solicitud.pedidos.entities.AlmacenesEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-11T11:38:59-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class AlmacenesMapperImpl implements AlmacenesMapper {

    @Override
    public List<AlmacenResponse> toAlmacenResponseList(List<AlmacenesEntity> almacenesEntities) {
        if ( almacenesEntities == null ) {
            return null;
        }

        List<AlmacenResponse> list = new ArrayList<AlmacenResponse>( almacenesEntities.size() );
        for ( AlmacenesEntity almacenesEntity : almacenesEntities ) {
            list.add( toAlmacenResponse( almacenesEntity ) );
        }

        return list;
    }

    @Override
    public AlmacenResponse toAlmacenResponse(AlmacenesEntity almacenesEntity) {
        if ( almacenesEntity == null ) {
            return null;
        }

        Integer idAlmacen = null;
        String codigo = null;
        String descripcion = null;

        idAlmacen = almacenesEntity.getIdAlmacen();
        codigo = almacenesEntity.getCodigo();
        descripcion = almacenesEntity.getDescripcion();

        AlmacenResponse almacenResponse = new AlmacenResponse( idAlmacen, codigo, descripcion );

        return almacenResponse;
    }
}
