package com.battilana.solicitud.pedidos.mapper;

import com.battilana.solicitud.pedidos.dtos.UsuarioRequest;
import com.battilana.solicitud.pedidos.dtos.UsuarioResponse;
import com.battilana.solicitud.pedidos.entities.UsuarioEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-10T08:59:02-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class UsuariosMapperImpl implements UsuariosMapper {

    @Override
    public List<UsuarioResponse> toUserResponseList(List<UsuarioEntity> usuarioEntityList) {
        if ( usuarioEntityList == null ) {
            return null;
        }

        List<UsuarioResponse> list = new ArrayList<UsuarioResponse>( usuarioEntityList.size() );
        for ( UsuarioEntity usuarioEntity : usuarioEntityList ) {
            list.add( toUserResponse( usuarioEntity ) );
        }

        return list;
    }

    @Override
    public UsuarioResponse toUserResponse(UsuarioEntity usuarioEntity) {
        if ( usuarioEntity == null ) {
            return null;
        }

        Long idUsuario = null;
        String names = null;
        String subnames = null;
        String email = null;
        String phone = null;
        LocalDate createAt = null;
        Long usuarioSapPredeterminado = null;
        String tipoUsuario = null;

        if ( usuarioEntity.getIdUsuario() != null ) {
            idUsuario = usuarioEntity.getIdUsuario().longValue();
        }
        names = usuarioEntity.getNames();
        subnames = usuarioEntity.getSubnames();
        email = usuarioEntity.getEmail();
        phone = usuarioEntity.getPhone();
        createAt = usuarioEntity.getCreateAt();
        usuarioSapPredeterminado = usuarioEntity.getUsuarioSapPredeterminado();
        if ( usuarioEntity.getTipoUsuario() != null ) {
            tipoUsuario = usuarioEntity.getTipoUsuario().name();
        }

        UsuarioResponse usuarioResponse = new UsuarioResponse( idUsuario, names, subnames, email, phone, createAt, usuarioSapPredeterminado, tipoUsuario );

        return usuarioResponse;
    }

    @Override
    public UsuarioEntity toUserEntity(UsuarioRequest usuarioRequest) {
        if ( usuarioRequest == null ) {
            return null;
        }

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setNames( usuarioRequest.names() );
        usuarioEntity.setSubnames( usuarioRequest.subnames() );
        usuarioEntity.setEmail( usuarioRequest.email() );
        usuarioEntity.setUsername( usuarioRequest.username() );
        usuarioEntity.setPassword( usuarioRequest.password() );

        return usuarioEntity;
    }
}
