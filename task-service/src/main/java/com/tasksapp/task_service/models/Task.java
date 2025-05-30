package com.tasksapp.task_service.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;
    private String description;
    private TASK_STATE status;
    private Date createdAt;

    @Column(name = "user", nullable = false)
    private String email;

    public Task() {
    }

    public Task(String title, String description, TASK_STATE status, Date createdAt, String email) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public TASK_STATE getStatus() {
        return status;
    }

    public void setStatus(TASK_STATE status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
