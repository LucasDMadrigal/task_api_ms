package com.tasksapp.auth_service.services;

import com.tasksapp.auth_service.DTOs.UserDTO;
import com.tasksapp.auth_service.model.Client;
import org.springframework.security.core.Authentication;

import java.util.List;


public interface ClientService {

    List<UserDTO> getAllClients();
    Client getClientById(Long id);
    // List<ClientDTO> getAllClientsDto();
    Client getClientByEmail(String email);
    void saveClient(Client client);
    Client getCurrentClient(Authentication authentication);

}
