package com.crud.SpringBootCrud.service;

import com.crud.SpringBootCrud.dto.UserDto;
import com.crud.SpringBootCrud.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public  User insertUser(User user);

    public List<UserDto> getAllUsers();

    public User getSingleUserById(Integer id);

    public Optional<User> updateUserById(User user);

    public Optional<User> deleteUserById(Integer id);
}
