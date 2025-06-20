package org.cibertec.solucionT2.repository;

import org.cibertec.solucionT2.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
}
