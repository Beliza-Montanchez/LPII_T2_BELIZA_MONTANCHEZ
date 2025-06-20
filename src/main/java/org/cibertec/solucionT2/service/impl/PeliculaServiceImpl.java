package org.cibertec.solucionT2.service.impl;

import org.cibertec.solucionT2.entity.PeliculaEntity;
import org.cibertec.solucionT2.repository.PeliculaRepository;
import org.cibertec.solucionT2.service.PeliculaService;
import org.springframework.stereotype.Service;

@Service
public class PeliculaServiceImpl extends GenericServiceImpl<PeliculaEntity, Integer> implements PeliculaService {

    public PeliculaServiceImpl(PeliculaRepository repository) {
        super(repository);
    }
}
