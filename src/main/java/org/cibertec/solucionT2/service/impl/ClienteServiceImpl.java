package org.cibertec.solucionT2.service.impl;

import org.cibertec.solucionT2.entity.ClienteEntity;
import org.cibertec.solucionT2.repository.ClienteRepository;
import org.cibertec.solucionT2.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<ClienteEntity, Integer> implements ClienteService {

    public ClienteServiceImpl(ClienteRepository repository) {
        super(repository);
    }
}
