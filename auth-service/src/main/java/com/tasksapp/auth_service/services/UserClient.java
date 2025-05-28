package com.tasksapp.auth_service.services;

import com.tasksapp.auth_service.DTOs.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserClient {
    private final WebClient webClient;

    public UserClient(@Value("${user.service.url}") String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    /**
     * Crea un nuevo usuario en el microservicio user-service.
     */

    public void createUser(UserDTO userDto) {
        webClient.post()
                .uri("/api/users")
                .bodyValue(userDto)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
