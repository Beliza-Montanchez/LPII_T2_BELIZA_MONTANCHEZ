package org.cibertec.solucionT2.service.impl;

import org.cibertec.solucionT2.entity.DetalleAlquilerEntity;
import org.cibertec.solucionT2.entity.DetalleAlquilerId;
import org.cibertec.solucionT2.repository.DetalleAlquilerRepository;
import org.cibertec.solucionT2.service.DetalleAlquilerService;
import org.springframework.stereotype.Service;

@Service
public class DetalleAlquilerServiceImpl extends GenericServiceImpl<DetalleAlquilerEntity, DetalleAlquilerId> implements DetalleAlquilerService {

    public DetalleAlquilerServiceImpl(DetalleAlquilerRepository repository) {
        super(repository);
    }
}
