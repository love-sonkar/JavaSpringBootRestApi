package com.crudapp.lovesonkar.repository;

import com.crudapp.lovesonkar.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
