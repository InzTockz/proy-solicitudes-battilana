package com.battilana.solicitud.pedidos.repositorys;

import com.battilana.solicitud.pedidos.entities.UsuariosSapEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioSapRepository extends JpaRepository<UsuariosSapEntity, Long> {
}
