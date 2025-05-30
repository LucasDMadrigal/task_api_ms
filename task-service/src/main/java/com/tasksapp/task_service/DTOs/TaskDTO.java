package com.tasksapp.task_service.DTOs;

import com.tasksapp.task_service.models.TASK_STATE;
import com.tasksapp.task_service.models.Task;

public class TaskDTO {
    private String title;
    private String description;
    private TASK_STATE status;

    public TaskDTO(Task task) {
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
}
