package com.crudapp.lovesonkar.controllers;

import com.crudapp.lovesonkar.model.Users;
import com.crudapp.lovesonkar.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173/"})
public class UsersController {

    @Autowired
    private UsersRepo users;

    @PostMapping("/signup")
    private ResponseEntity<Users> signUpUser(@RequestBody Users data) {
        String username = data.getUsername();
        Users userObj = users.findByUsername(username);
        if (userObj != null) {
            if (username.equals(userObj.getUsername())) {
                return new ResponseEntity("Already Registerd", HttpStatus.CONFLICT);
            }
        }
        Users userdata = users.save(data);
        Users sendObj = new Users();
        sendObj.setId(userdata.getId());
        sendObj.setUsername(userdata.getUsername());
        return ResponseEntity.ok(sendObj);
    }

    @PostMapping("/login")
    private ResponseEntity<Users> loginUser(@RequestBody Users data) {
        String username = data.getUsername();
        Users userObj = users.findByUsername(username);
        if (userObj != null) {
            if (!username.equals(userObj.getUsername())) {
                return new ResponseEntity("User not Found", HttpStatus.NOT_FOUND);
            }
            if (!data.getPassword().equals(userObj.getPassword())) {
                return new ResponseEntity("password not match", HttpStatus.NOT_FOUND);

            }
            Users sendObj = new Users();
            sendObj.setId(userObj.getId());
            sendObj.setUsername(userObj.getUsername());
            return ResponseEntity.ok(sendObj);
        } else {
            return new ResponseEntity("Not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/alluser")
    List<Users> getAllUser(){
        return users.findAll();
    }


}
