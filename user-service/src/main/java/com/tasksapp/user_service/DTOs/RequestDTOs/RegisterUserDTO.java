package com.tasksapp.user_service.DTOs.RequestDTOs;

public record RegisterUserDTO(String firstName, String lastName, String email, String password, String rol) {}