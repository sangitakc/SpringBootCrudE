package com.crud.SpringBootCrud.service;

import com.crud.SpringBootCrud.dao.UserDao;
import com.crud.SpringBootCrud.dto.UserDto;
import com.crud.SpringBootCrud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

     @Override
    public User insertUser(User user) {
        return (User) userDao.insData(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDao.AllUsers();
    }

    @Override
    public User getSingleUserById(Integer id) {
        return userDao.getSingleUser(id);

    }

    @Override
    public Optional<User> updateUserById(User user) {
        return userDao.updUsers(user);

    }

    @Override
    public Optional<User> deleteUserById(Integer id) {
        return userDao.delData(id);

    }
}
