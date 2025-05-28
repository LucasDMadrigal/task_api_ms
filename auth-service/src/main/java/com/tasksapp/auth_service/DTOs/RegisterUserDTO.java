package com.tasksapp.auth_service.DTOs;

public record RegisterUserDTO(String firstName, String lastName, String email, String password, String role, String rol) {
}
