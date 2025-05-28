package com.tasksapp.user_service.repositorys;

import com.tasksapp.user_service.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}
