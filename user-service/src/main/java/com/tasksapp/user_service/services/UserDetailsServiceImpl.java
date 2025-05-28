package com.tasksapp.user_service.services;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.tasksapp.user_service.models.Users;
import com.tasksapp.user_service.repositorys.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No se encontró el usuario con email: " + email);
        }

        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .roles("USER") // o cargar el rol real si lo tenés
                .build();
    }
}
