package com.tasksapp.auth_service.services;

import com.tasksapp.auth_service.DTOs.UserDTO;
import com.tasksapp.auth_service.model.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;

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

    public UserDTO createUser(Client userDto) {
        try {
            return webClient.post()
                    .uri("/api/users/create")
                    .bodyValue(userDto)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, response -> {
                        System.err.println("Error 4xx al crear usuario: " + response.statusCode());
                        return Mono.error(new RuntimeException("Cliente inválido al registrar usuario"));
                    })
                    .onStatus(HttpStatusCode -> HttpStatusCode.is5xxServerError(), response -> {
                        System.err.println("Error 5xx del servidor al crear usuario: " + response.statusCode());
                        return Mono.error(new RuntimeException("Error interno del servidor al registrar usuario"));
                    })
                    .bodyToMono(UserDTO.class)
                    .block();
        } catch (WebClientResponseException e) {
            System.err.println("Error HTTP al llamar a user-service: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            return null;
        } catch (Exception e) {
            System.err.println("Error general al registrar usuario en user-service: " + e.getMessage());
            return null;
        }
    }
}
