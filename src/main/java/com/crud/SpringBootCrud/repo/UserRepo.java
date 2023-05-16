package com.crud.SpringBootCrud.repo;

import com.crud.SpringBootCrud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
