package com.example.demo.repositories;



import com.example.demo.entities.Reservation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ReservationRepository extends MongoRepository<Reservation, ObjectId> {

}
