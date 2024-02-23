package com.crudapp.lovesonkar.repository;

import com.crudapp.lovesonkar.model.AdminUser;
import com.crudapp.lovesonkar.model.Testadmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface AdminRepo extends JpaRepository<AdminUser,Integer> {
    AdminUser findByUsername(String username);

    @Query("Select id,username from users")
    List<List<?>> findAllUser();

}
