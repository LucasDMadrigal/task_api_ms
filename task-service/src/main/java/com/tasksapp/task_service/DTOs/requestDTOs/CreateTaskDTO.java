package com.tasksapp.task_service.DTOs.requestDTOs;

import com.tasksapp.task_service.models.TASK_STATE;

public record CreateTaskDTO(String title, String description, TASK_STATE status) {
}
