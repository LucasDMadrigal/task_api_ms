package com.tasksapp.task_service.DTOs;

import com.tasksapp.task_service.models.TASK_STATE;
import com.tasksapp.task_service.models.Task;

import java.util.Date;

public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private TASK_STATE status;
    private Date createdAt;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.createdAt = task.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TASK_STATE getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
