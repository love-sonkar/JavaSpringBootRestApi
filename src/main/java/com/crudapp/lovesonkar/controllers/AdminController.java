package com.crudapp.lovesonkar.controllers;

import com.crudapp.lovesonkar.model.AdminUser;
import com.crudapp.lovesonkar.model.Notes;
import com.crudapp.lovesonkar.model.Testadmin;
import com.crudapp.lovesonkar.model.Users;
import com.crudapp.lovesonkar.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = {"http://localhost:5173/"})
public class AdminController {

    @Autowired
    private AdminRepo adminRepo;

//    @PostMapping("/adminsignup")
//    private String signupAdmin(@RequestBody AdminUser admin) {
//        adminRepo.save(admin);
//        return "done";
//    }

    @PostMapping("/loginadmin")
    private ResponseEntity<String> loginAdmin(@RequestBody AdminUser admin) {
        String adminUsername = admin.getUsername();
        AdminUser adminRes = adminRepo.findByUsername(adminUsername);
        if (admin != null) {

            if (!adminUsername.equals(adminRes.getUsername())) {
                return new ResponseEntity<>("Admin Not Found", HttpStatus.NOT_FOUND);
            }
            if (!admin.getPassword().equals(adminRes.getPassword())) {
                return new ResponseEntity<>("Password Not match", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(adminRes.getUsername());

        } else {
            return new ResponseEntity("Admin not Found", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/alladmin")
    private List<AdminUser> allAdmmin() {
        return adminRepo.findAll();
    }

    @GetMapping("/getadmin")
    private List<Testadmin>  getAdmin() {
        List<List<?>> adminList = adminRepo.findAllUser();
        List<Testadmin> adminObject = new ArrayList<>();
        for (int i = 0; i < adminList.size(); i++) {
            Testadmin createObject = new Testadmin((Integer) adminList.get(i).get(0),(String)adminList.get(i).get(1));
            adminObject.add(createObject);
        }
        return adminObject;
    }


}
