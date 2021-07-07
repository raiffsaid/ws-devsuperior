package com.raiffsaid.challenge1.services;

import com.raiffsaid.challenge1.dto.ClientDTO;
import com.raiffsaid.challenge1.entities.Client;
import com.raiffsaid.challenge1.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
        Page<Client> list = repository.findAll(pageRequest);

        return list.map(ClientDTO::new);
    }


}
