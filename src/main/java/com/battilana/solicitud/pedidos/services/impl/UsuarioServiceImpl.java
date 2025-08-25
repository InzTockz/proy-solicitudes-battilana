package com.battilana.solicitud.pedidos.services.impl;

import com.battilana.solicitud.pedidos.dtos.UsuarioRequest;
import com.battilana.solicitud.pedidos.dtos.UsuarioResponse;
import com.battilana.solicitud.pedidos.entities.UsuarioEntity;
import com.battilana.solicitud.pedidos.mapper.UsuariosMapper;
import com.battilana.solicitud.pedidos.repositorys.UsuarioRepository;
import com.battilana.solicitud.pedidos.services.UsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuariosMapper usuariosMapper;
    private final BCryptPasswordEncoder encoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuariosMapper usuariosMapper, BCryptPasswordEncoder encoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuariosMapper = usuariosMapper;
        this.encoder = encoder;
    }

    @Override
    public List<UsuarioResponse> listUsers() {
        return this.usuariosMapper.toUserResponseList(this.usuarioRepository.findAll());
    }

    @Override
    public UsuarioResponse addUser(UsuarioRequest usuarioRequest) {
        UsuarioEntity usuarioEntity = this.usuariosMapper.toUserEntity(usuarioRequest);
        usuarioEntity.setPassword(encoder.encode(usuarioRequest.password()));
        return this.usuariosMapper.toUserResponse(this.usuarioRepository.save(usuarioEntity));
    }

    @Override
    public UsuarioResponse updateUser(Long idUsuario, UsuarioRequest usuarioRequest) {
        if (idUsuario != null) {
            UsuarioEntity usuarioEntity = this.usuariosMapper.toUserEntity(usuarioRequest);
            usuarioEntity.setIdUsuario(idUsuario);
            return this.usuariosMapper.toUserResponse(usuarioEntity);
        } else {
            return null;
        }
    }

    @Override
    public UsuarioResponse findUsuario(Long idUsuario) {
        if(idUsuario!=null){
            return this.usuariosMapper.toUserResponse(this.usuarioRepository.findById(idUsuario).get());
        }
        else {
            return null;
        }
    }

    @Override
    public void disableUser(Long idUsuario) {
        UsuarioEntity usuarioEntity = this.usuarioRepository.findById(idUsuario).get();
        usuarioEntity.setStatus(false);
        this.usuarioRepository.save(usuarioEntity);
    }
}
