package com.tasksapp.user_service.services.ServiceImpl;

import com.tasksapp.user_service.DTOs.RequestDTOs.RegisterUserDTO;
import com.tasksapp.user_service.DTOs.UsersDTO;
import com.tasksapp.user_service.models.Users;
import com.tasksapp.user_service.repositorys.UsersRepository;
import com.tasksapp.user_service.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<UsersDTO> findAllUsers() {
        return usersRepository.findAll().stream().map(UsersDTO::new).toList();
    }

    @Override
    public UsersDTO findUserById(Long id) {
        return usersRepository.findById(id).map(UsersDTO::new).orElse(null);
    }

    @Override
    public UsersDTO findUserByEmail(String email) {
        UsersDTO userDto = new UsersDTO(usersRepository.findByEmail(email));
        return userDto;
    }

    @Override
    public Users saveUser(RegisterUserDTO user) {
        Users newUser = new Users(
                user.firstName(),
                user.lastName(),
                user.email(),
                user.password(),
                "USER"
        );
        return usersRepository.save(newUser);
    }

}
