package com.tasksapp.task_service.controllers;

import com.tasksapp.task_service.DTOs.TaskDTO;
import com.tasksapp.task_service.DTOs.requestDTOs.CreateTaskDTO;
import com.tasksapp.task_service.DTOs.requestDTOs.UpdateTaskDTO;
import com.tasksapp.task_service.serices.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@RequestBody CreateTaskDTO createTaskDTO,
                                              @AuthenticationPrincipal UserDetails userDetails) {

        try {
        TaskDTO taskDTO = taskService.createTask(createTaskDTO, userDetails.getUsername());
        return new ResponseEntity<>(taskDTO, HttpStatus.CREATED); // ResponseEntity
        } catch (Exception e) {
            return new ResponseEntity<>("create failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTasks(@AuthenticationPrincipal UserDetails userDetails) {

        if (userDetails == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        try {
        List<TaskDTO> tasks = taskService.getTasksByEmail(userDetails.getUsername());
        return new ResponseEntity<>(tasks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("login failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody UpdateTaskDTO updateTaskDTO) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
        TaskDTO taskDTO = taskService.updateTask(id, updateTaskDTO);
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("update failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
