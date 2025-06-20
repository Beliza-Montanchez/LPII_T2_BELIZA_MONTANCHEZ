package org.cibertec.solucionT2.repository;

import org.cibertec.solucionT2.entity.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Integer> {
}
