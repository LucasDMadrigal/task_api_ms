package com.tasksapp.auth_service.services.ServiceImpl;

import com.tasksapp.auth_service.DTOs.AuthUserDTO;
import com.tasksapp.auth_service.model.Client;
import com.tasksapp.auth_service.repository.ClientRepository;
import com.tasksapp.auth_service.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<AuthUserDTO> getAllClients() {
        return clientRepository.findAll().stream().map(AuthUserDTO::new).toList();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getCurrentClient(Authentication authentication) {
        return getClientByEmail(authentication.getName());
    }
}
