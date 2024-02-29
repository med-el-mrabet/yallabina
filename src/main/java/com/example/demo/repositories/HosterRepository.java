package com.example.demo.repositories;


import com.example.demo.entities.Hoster;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.Optional;


public interface HosterRepository extends MongoRepository<Hoster, ObjectId> {
    Hoster findByEmail(String email);

}
