package com.tasksapp.task_service.DTOs.requestDTOs;

import com.tasksapp.task_service.models.TASK_STATE;

public record UpdateTaskDTO(String title, String description, TASK_STATE status) {
}
