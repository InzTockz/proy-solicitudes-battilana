package com.battilana.solicitud.pedidos.security;

import com.battilana.solicitud.pedidos.dtos.UsuarioResponse;
import com.battilana.solicitud.pedidos.entities.UsuarioEntity;
import com.battilana.solicitud.pedidos.mapper.UsuariosMapper;
import com.battilana.solicitud.pedidos.repositorys.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomDetailService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final UsuariosMapper usuariosMapper;

    public CustomDetailService(UsuarioRepository usuarioRepository, UsuariosMapper usuariosMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuariosMapper = usuariosMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //UsuarioResponse usuarioResponse = this.usuariosMapper.toUserResponse(this.usuarioRepository.findByUsername(username).get());
        UsuarioEntity usuarioEntity = this.usuarioRepository.findByUsername(username).get();

//        UserDetails userDetails = User.builder()
//                .username(usuario.username())
//                .password(usuarioResponse.password())
//                .roles(usuarioResponse.roles().name())
//                .build();
        UserDetails userDetails = User.builder()
                .username(usuarioEntity.getUsername())
                .password(usuarioEntity.getPassword())
                .roles(usuarioEntity.getRoles().name())
                .build();
        return userDetails;
    }
}
