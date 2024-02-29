package com.example.demo.services;

import com.example.demo.entities.Reservation;
import com.example.demo.repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public List<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }
    public Optional<Reservation> getSingleReservation(ObjectId id){
        return reservationRepository.findById(id);
    }

    public ReservationService() {
    }

    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
    public void deleteHoster(ObjectId id) {
        reservationRepository.deleteById(id);
    }
}
