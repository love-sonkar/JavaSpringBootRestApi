package com.crudapp.lovesonkar.controllers;

import com.crudapp.lovesonkar.model.AdminUser;
import com.crudapp.lovesonkar.model.Users;
import com.crudapp.lovesonkar.repository.AdminRepo;
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

    @Autowired
    private AdminRepo admin;

    @PostMapping("/signup")
    private ResponseEntity<String> signUpUser(@RequestBody Users data) {
        String username = data.getUsername();
        Users userObj = users.findByUsername(username);
        if (userObj != null) {
            if (username.equals(userObj.getUsername())) {
                return new ResponseEntity("Already Registerd", HttpStatus.CONFLICT);
            }
        }
        Users userdata = users.save(data);
        AdminUser admindata = admin.findByUsername("admin");
        admindata.setUserList(userdata);
        admin.save(admindata);
        return ResponseEntity.ok(userdata.getUsername());
    }

    @PostMapping("/login")
    private ResponseEntity<String> loginUser(@RequestBody Users data) {
        String username = data.getUsername();
        Users userObj = users.findByUsername(username);
        if (userObj != null) {
            if (!username.equals(userObj.getUsername())) {
                return new ResponseEntity("User not Found", HttpStatus.NOT_FOUND);
            }
            if (!data.getPassword().equals(userObj.getPassword())) {
                return new ResponseEntity("password not match", HttpStatus.NOT_FOUND);

            }
            return ResponseEntity.ok(userObj.getUsername());
        } else {
            return new ResponseEntity("Not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/alluser")
    List<Users> getAllUser(){
        return users.findAll();
    }


    @DeleteMapping("/user/{username}")
    private ResponseEntity<String> deleteUser(@PathVariable String username){
        Users currentUser = users.findByUsername(username);
        if(currentUser != null) {
            users.deleteById(currentUser.getId());
            return new ResponseEntity<>("SuccessFully Deleted User", HttpStatus.ACCEPTED);
        }else{
          return new ResponseEntity("User Not Found",HttpStatus.NOT_FOUND);
        }
    }

}
