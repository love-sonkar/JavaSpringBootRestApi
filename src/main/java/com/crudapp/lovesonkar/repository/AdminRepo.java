package com.crudapp.lovesonkar.repository;

import com.crudapp.lovesonkar.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<AdminUser,Integer> {
    AdminUser findByUsername(String username);
}
