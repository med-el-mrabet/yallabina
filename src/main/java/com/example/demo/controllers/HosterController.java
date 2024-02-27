package com.example.demo.controllers;

import com.example.demo.entities.Hoster;
import com.example.demo.hosterservice;
import com.example.demo.services.HosterService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
public class HosterController {
    @Autowired
    private final HosterService hosterService;

    public HosterController(HosterService hosterService) {
        this.hosterService = hosterService;
    }


    @GetMapping("/api/hosters")
    public ResponseEntity<List<Hoster>> getAllHosters(){
        return new ResponseEntity<>(hosterService.getAllHosters(), HttpStatus.OK);
    }

    @GetMapping("/api/hosters/{id}")
    public ResponseEntity<Optional<Hoster>> getSingleHoster(@PathVariable ObjectId id){
        return new ResponseEntity<>(hosterService.getSingleHoster(id), HttpStatus.OK);
    }

    @PostMapping("/api/hosters/add")
    public void addAgence(@RequestBody Hoster hoster){
        hosterService.saveHoster(hoster);
    }

    @DeleteMapping("/api/hosters/delete/{id}")
    public void deleteHoster(@PathVariable ObjectId id) {
        hosterService.deleteHoster(id);
    }

    @PutMapping("/api/hosters/update/{id}")
    public ResponseEntity<String> updateHoster(@PathVariable ObjectId id, @RequestBody Hoster updateHoster) {
        Optional<Hoster> existingHoster = hosterService.getSingleHoster(id);

        if (existingHoster.isPresent()) {
            if (updateHoster.getName() != null) {
                existingHoster.get().setName(updateHoster.getName());
            }

            if (updateHoster.getAdresse() != null) {
                existingHoster.get().setAdresse(updateHoster.getAdresse());
            }

            if (updateHoster.getCni() != null) {
                existingHoster.get().setCni(updateHoster.getCni());
            }

            if (updateHoster.getPhone_number() != null) {
                existingHoster.get().setPhone_number(updateHoster.getPhone_number());
            }

            if (updateHoster.getRib() != null) {
                existingHoster.get().setRib(updateHoster.getRib());
            }
            if (updateHoster.getAge() != null) {
                existingHoster.get().setAge(updateHoster.getAge());
            }
            if (updateHoster.getCategory() != null) {
                existingHoster.get().setCategory(updateHoster.getCategory());
            }
            if (updateHoster.getUsername() != null) {
                existingHoster.get().setUsername(updateHoster.getUsername());
            }
            if (updateHoster.getPassword() != null) {
                existingHoster.get().setPassword(updateHoster.getPassword());
            }
            if (updateHoster.getEmail() != null) {
                existingHoster.get().setEmail(updateHoster.getEmail());
            }

            hosterService.saveHoster(existingHoster);

            String successMessage = "Hoster updated successfully";
            return ResponseEntity.ok().body("{\"message\":\""+successMessage+"\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
