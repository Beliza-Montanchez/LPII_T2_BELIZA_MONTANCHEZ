package org.cibertec.solucionT2.repository;

import org.cibertec.solucionT2.entity.DetalleAlquilerEntity;
import org.cibertec.solucionT2.entity.DetalleAlquilerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleAlquilerRepository extends JpaRepository<DetalleAlquilerEntity, DetalleAlquilerId> {
}
