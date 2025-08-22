package com.battilana.solicitud.pedidos.repositorys;

import com.battilana.solicitud.pedidos.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
