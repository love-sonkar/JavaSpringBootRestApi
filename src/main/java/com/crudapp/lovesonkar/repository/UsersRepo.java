package com.crudapp.lovesonkar.repository;

import com.crudapp.lovesonkar.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

public interface UsersRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);

//    @Query("select id,username from users")
//    List<Users> fetchAllUser();

}
