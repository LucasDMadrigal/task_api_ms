package com.tasksapp.task_service.serices.serviceImpl;

import com.tasksapp.task_service.DTOs.TaskDTO;
import com.tasksapp.task_service.DTOs.requestDTOs.CreateTaskDTO;
import com.tasksapp.task_service.DTOs.requestDTOs.UpdateTaskDTO;
import com.tasksapp.task_service.models.Task;
import com.tasksapp.task_service.repositories.TaskRepository;
import com.tasksapp.task_service.serices.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public TaskDTO createTask(CreateTaskDTO createTaskDTO, String email) {
        Task newTask = new Task(createTaskDTO.title(), createTaskDTO.description(), createTaskDTO.status(), new Date(), email);
        return new TaskDTO(newTask);
    }

    @Override
    public List<TaskDTO> getTasksByEmail(String email) {
        return taskRepository.findByUserEmail(email).stream().map(TaskDTO::new).toList();
    }

    @Override
    public TaskDTO updateTask(Long id, UpdateTaskDTO updateTaskDTO) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
        return null;
        }
        task.setTitle(updateTaskDTO.title());
        task.setDescription(updateTaskDTO.description());
        task.setStatus(updateTaskDTO.status());
        return new TaskDTO(taskRepository.save(task));
    }
}
