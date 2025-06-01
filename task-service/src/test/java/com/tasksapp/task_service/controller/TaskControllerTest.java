package com.tasksapp.task_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tasksapp.task_service.DTOs.requestDTOs.CreateTaskDTO;
import com.tasksapp.task_service.models.TASK_STATE;
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
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private final String token = "Bearer TU_TOKEN_JWT_VALIDO";

    @Test
    public void testCreateTask_ReturnsOk() throws Exception {
        CreateTaskDTO taskDTO = new CreateTaskDTO(
                "Probar microservicio",
                "Crear test para controlador",
                TASK_STATE.PENDING
        );

        mockMvc.perform(post("/api/tasks/create")
                        .header("Authorization", token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(taskDTO)))
                .andExpect(status().isCreated());
    }
}
