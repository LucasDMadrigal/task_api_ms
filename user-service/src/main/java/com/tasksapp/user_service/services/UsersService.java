package com.tasksapp.user_service.services;

import com.tasksapp.user_service.DTOs.RequestDTOs.RegisterUserDTO;
import com.tasksapp.user_service.DTOs.UsersDTO;
import com.tasksapp.user_service.models.Users;

import java.util.List;

public interface UsersService {

    public List<UsersDTO> findAllUsers();
    public UsersDTO findUserById(Long id);
    public UsersDTO findUserByEmail(String email);
   public Users saveUser(RegisterUserDTO user);
}
