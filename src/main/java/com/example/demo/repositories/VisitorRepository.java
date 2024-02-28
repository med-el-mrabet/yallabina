package com.example.demo.repositories;


import com.example.demo.entities.Visitor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface VisitorRepository extends MongoRepository<Visitor, ObjectId> {

}
