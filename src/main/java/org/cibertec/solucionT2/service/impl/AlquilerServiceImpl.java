package org.cibertec.solucionT2.service.impl;

import org.cibertec.solucionT2.entity.AlquilerEntity;
import org.cibertec.solucionT2.repository.AlquilerRepository;
import org.cibertec.solucionT2.service.AlquilerService;
import org.springframework.stereotype.Service;

@Service
public class AlquilerServiceImpl extends GenericServiceImpl<AlquilerEntity, Integer> implements AlquilerService {

    public AlquilerServiceImpl(AlquilerRepository repository) {
        super(repository);
    }
}
