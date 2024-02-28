package com.example.demo.repositories;



import com.example.demo.entities.Listing;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ListingRepository extends MongoRepository<Listing, ObjectId> {

}
