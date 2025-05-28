package com.tasksapp.auth_service.DTOs;

import com.tasksapp.auth_service.model.Client;

public class AuthUserDTO {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;

    public AuthUserDTO(Client user) {
        this.Id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    public Long getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
