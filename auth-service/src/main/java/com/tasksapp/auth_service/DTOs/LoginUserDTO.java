package com.tasksapp.auth_service.DTOs;

import org.springframework.lang.NonNull;

public record LoginUserDTO(String email, String password) {
}
