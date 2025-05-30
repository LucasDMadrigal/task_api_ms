package com.tasksapp.task_service.serices;

import com.tasksapp.task_service.DTOs.TaskDTO;
import com.tasksapp.task_service.DTOs.requestDTOs.CreateTaskDTO;
import com.tasksapp.task_service.DTOs.requestDTOs.UpdateTaskDTO;
import com.tasksapp.task_service.models.Task;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(CreateTaskDTO createTaskDTO, String email);
    List<TaskDTO> getTasksByEmail(String email);
    TaskDTO updateTask(Long id, UpdateTaskDTO updateTaskDTO);
}
