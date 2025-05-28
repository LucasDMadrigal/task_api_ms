package com.tasksapp.user_service.controllers;

import com.tasksapp.user_service.DTOs.RequestDTOs.RegisterUserDTO;
import com.tasksapp.user_service.DTOs.UsersDTO;
import com.tasksapp.user_service.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/all")
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        List<UsersDTO> users = usersService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> getUserById(@PathVariable Long id) {
        UsersDTO user = usersService.findUserById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/create")
    public ResponseEntity<UsersDTO> createUser(@RequestBody RegisterUserDTO user) {
        UsersDTO newUser = new UsersDTO(usersService.saveUser(user));
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UsersDTO> updateUser(@PathVariable Long id, @RequestBody RegisterUserDTO user) {
        UsersDTO updatedUser = new UsersDTO(usersService.saveUser(user));
        return ResponseEntity.ok(updatedUser);
    }

}
