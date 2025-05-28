package com.tasksapp.auth_service.serviceSecurity;

import com.tasksapp.auth_service.model.Client;
import com.tasksapp.auth_service.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(username);

        System.out.println("client: " + client);
        if (client == null) {
            throw new UsernameNotFoundException("User not found");
        }
        else {

        return User
                .withUsername(client.getEmail())
                .password(client.getPassword())
                .roles(client.getRol())
                .build();
        }
    }
}
