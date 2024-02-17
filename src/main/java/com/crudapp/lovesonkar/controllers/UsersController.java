package com.crudapp.lovesonkar.controllers;

import com.crudapp.lovesonkar.model.Users;
import com.crudapp.lovesonkar.repository.UsersRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:5173/"})
public class UsersController {

    @Autowired
    private UsersRepo users;

    @PostMapping("/signup")
    private String signUpUser(@RequestBody Users data) {
        String username = data.getUsername();
        Users userObj = users.findByUsername(username);
        if (userObj != null) {
            if (username.equals(userObj.getUsername())) {
                return "User Already Exists";
            }
        }
        users.save(data);
        return "data saved";
    }

    @PostMapping("/login")
    private ResponseEntity<Users> loginUser(@RequestBody Users data) {
        String username = data.getUsername();
        Users userObj = users.findByUsername(username);
        if (userObj != null) {
            if (!username.equals(userObj.getUsername())) {
                return new ResponseEntity("User not Found",HttpStatus.NOT_FOUND);
            }
            if (!data.getPassword().equals(userObj.getPassword())) {
         return new ResponseEntity("password not match",HttpStatus.NOT_FOUND);

            }
            return ResponseEntity.ok(userObj);
        } else {
            return new ResponseEntity("Not found",HttpStatus.NOT_FOUND);
        }
    }

}
