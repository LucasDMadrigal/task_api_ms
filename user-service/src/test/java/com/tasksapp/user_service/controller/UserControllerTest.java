package com.tasksapp.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tasksapp.user_service.DTOs.RequestDTOs.RegisterUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateUser_ReturnsOk() throws Exception {
        RegisterUserDTO user = new RegisterUserDTO(
                "Juan",
                "Pérez",
                "juan" + System.currentTimeMillis() + "@test.com", // evita duplicados
                "123456",
                "USER"
        );

        mockMvc.perform(post("/api/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

    }
}
