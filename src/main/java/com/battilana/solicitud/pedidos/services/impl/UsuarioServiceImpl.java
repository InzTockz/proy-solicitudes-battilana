package com.battilana.solicitud.pedidos.services.impl;

import com.battilana.solicitud.pedidos.dtos.LoginRequest;
import com.battilana.solicitud.pedidos.dtos.LoginResponse;
import com.battilana.solicitud.pedidos.dtos.UsuarioRequest;
import com.battilana.solicitud.pedidos.dtos.UsuarioResponse;
import com.battilana.solicitud.pedidos.entities.UsuarioEntity;
import com.battilana.solicitud.pedidos.jwt.JwtGenerator;
import com.battilana.solicitud.pedidos.mapper.UsuariosMapper;
import com.battilana.solicitud.pedidos.repositorys.UsuarioRepository;
import com.battilana.solicitud.pedidos.services.UsuarioService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuariosMapper usuariosMapper;
    private final BCryptPasswordEncoder encoder;
    private final JwtGenerator jwtGenerator;
    private final AuthenticationManager authenticationManager;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuariosMapper usuariosMapper, BCryptPasswordEncoder encoder, JwtGenerator jwtGenerator, AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.usuariosMapper = usuariosMapper;
        this.encoder = encoder;
        this.jwtGenerator = jwtGenerator;
        this.authenticationManager = authenticationManager;
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

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<UsuarioEntity> usuarioEntity = this.usuarioRepository.findByUsername(loginRequest.username());

        if(usuarioEntity.isPresent()){
            boolean passwordIsTrue = this.encoder.matches(loginRequest.password(), usuarioEntity.get().getPassword());

            if (loginRequest.username().equals(usuarioEntity.get().getUsername()) &&
                    passwordIsTrue){
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password())
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);
                String token = this.jwtGenerator.getToken(loginRequest.username());

                return new LoginResponse(usuarioEntity.get().getIdUsuario(),
                        usuarioEntity.get().getNames(),
                        usuarioEntity.get().getSubnames(),
                        token,
                        "success");
            } else {
                return new LoginResponse(null,
                        "",
                        "",
                        "",
                        "error");
            }
        } else {
            return new LoginResponse(null,
                    "",
                    "",
                    "",
                    "error");
        }
    }
}
