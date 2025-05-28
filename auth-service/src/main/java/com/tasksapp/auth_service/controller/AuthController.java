package com.tasksapp.auth_service.controller;

import com.tasksapp.auth_service.DTOs.LoginUserDTO;
import com.tasksapp.auth_service.DTOs.RegisterUserDTO;
import com.tasksapp.auth_service.DTOs.UserDTO;
import com.tasksapp.auth_service.model.Client;
import com.tasksapp.auth_service.serviceSecurity.UserDetailServiceImpl;
import com.tasksapp.auth_service.services.ClientService;
import com.tasksapp.auth_service.services.UserClient;
import com.tasksapp.auth_service.util.JwtUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ClientService clientService;

    @Autowired
    private JwtUtilService jwtUtilService;

    @Autowired
    private UserDetailServiceImpl userDetailsServiceImp;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserClient userClient;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUserDTO registerUserDTO) {

        if (clientService.getClientByEmail(registerUserDTO.email()) != null) {
            return new ResponseEntity<>("Client already exists", HttpStatus.BAD_REQUEST);
        }
        if (registerUserDTO.firstName() == null || registerUserDTO.lastName() == null || registerUserDTO.email() == null || registerUserDTO.password() == null) {
            return new ResponseEntity<>("Missing fields", HttpStatus.BAD_REQUEST);
        }

        Client newUser = new Client(
                registerUserDTO.firstName(),
                registerUserDTO.lastName(),
                registerUserDTO.email(),
                passwordEncoder.encode(registerUserDTO.password()),
                registerUserDTO.rol()
        );

        clientService.saveClient(newUser);

        UserDTO userDto = new UserDTO(
                registerUserDTO.firstName(),
                registerUserDTO.lastName(),
                registerUserDTO.email()
        );

        userClient.createUser(userDto);

        return new ResponseEntity<>("Client created", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDTO loginUserDTO) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDTO.email(), loginUserDTO.password()));

            final UserDetails userDetails = userDetailsServiceImp.loadUserByUsername(loginUserDTO.email());

            final String jwt = jwtUtilService.generateToken(userDetails);
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("login failed", HttpStatus.BAD_REQUEST);
        }
    }
}
