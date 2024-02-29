package com.example.demo.services;

import com.example.demo.entities.Visitor;
import com.example.demo.repositories.VisitorRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;
    public List<Visitor> getAllVisitors(){
        return visitorRepository.findAll();
    }
    public Optional<Visitor> getSingleVisitor(ObjectId id){
        return visitorRepository.findById(id);
    }

    public void saveVisitor(Visitor visitor) {
        visitorRepository.save(visitor);
    }
    public void deleteHoster(ObjectId id) {
        visitorRepository.deleteById(id);
    }
}
