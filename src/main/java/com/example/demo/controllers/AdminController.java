package com.example.demo.controllers;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Hoster;
import com.example.demo.services.AdminService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {
    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/api/admins")
    public ResponseEntity<List<Admin>> getAllAdmin(){
        return new ResponseEntity<>(adminService.getAllAdmin(), HttpStatus.OK);
    }

    @GetMapping("/api/admins/{id}")
    public ResponseEntity<Admin> getSingleAdmin(@PathVariable ObjectId id){
        return new ResponseEntity<>(adminService.getSingleAdmin(id), HttpStatus.OK);
    }

    @PostMapping("/api/admins/add")
    public void addAgence(@RequestBody Admin admin){
        adminService.saveAdmin(admin);
    }

    @DeleteMapping("/api/admins/delete/{id}")
    public void deleteHoster(@PathVariable ObjectId id) {
        adminService.deleteHoster(id);
    }

}
