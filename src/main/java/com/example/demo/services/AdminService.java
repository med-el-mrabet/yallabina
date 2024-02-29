package com.example.demo.services;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    public List<Admin> getAllAdmin(){
        return adminRepository.findAll();
    }
    public Admin getSingleAdmin(ObjectId id){
        return adminRepository.findById(id).orElse(null);
    }

    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }
    public void deleteHoster(ObjectId id) {
        adminRepository.deleteById(id);
    }
}
