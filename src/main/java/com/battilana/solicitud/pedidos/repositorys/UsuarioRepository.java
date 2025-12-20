package com.battilana.solicitud.pedidos.repositorys;

import com.battilana.solicitud.pedidos.entities.AlmacenesEntity;
import com.battilana.solicitud.pedidos.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByUsername(String username);
    UsuarioEntity findByCodVendedor(Integer codVendedor);

    @Query("""
    SELECT a
    FROM UsuarioEntity u
    JOIN u.almacenes a
    where u.codVendedor =:codVendedor
    """
    )
    List<AlmacenesEntity> findAlmacenesEntityByCodVendedor(@Param("codVendedor") Integer codVendedor);
}
