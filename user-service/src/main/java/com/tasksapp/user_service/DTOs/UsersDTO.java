package com.tasksapp.user_service.DTOs;


import com.tasksapp.user_service.models.Users;

public class UsersDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public UsersDTO(Users user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
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
