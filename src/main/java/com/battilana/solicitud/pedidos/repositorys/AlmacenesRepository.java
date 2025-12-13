package com.battilana.solicitud.pedidos.repositorys;

import com.battilana.solicitud.pedidos.entities.AlmacenesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenesRepository extends JpaRepository<AlmacenesEntity, Integer> {
}
