package com.example.demo.repositories;



import com.example.demo.entities.Admin;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AdminRepository extends MongoRepository<Admin, ObjectId> {
}
