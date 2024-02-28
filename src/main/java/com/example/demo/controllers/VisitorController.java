package com.example.demo.controllers;

import com.example.demo.entities.Visitor;
import com.example.demo.services.VisitorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VisitorController {
    @Autowired
    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }


    @GetMapping("/api/visitors")
    public ResponseEntity<List<Visitor>> getAllVisitor(){
        return new ResponseEntity<>(visitorService.getAllVisitors(), HttpStatus.OK);
    }

    @GetMapping("/api/visitors/{id}")
    public ResponseEntity<Optional<Visitor>> getSingleVisitor(@PathVariable ObjectId id){
        return new ResponseEntity<>(visitorService.getSingleVisitor(id), HttpStatus.OK);
    }

    @PostMapping("/api/visitors/add")
    public void addAgence(@RequestBody Visitor visitor){
        visitorService.saveVisitor(visitor);
    }

}
