package com.example.demo.controllers;

import com.example.demo.entities.Reservation;
import com.example.demo.services.ReservationService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {
    @Autowired
    private final ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping("/api/reservations")
    public ResponseEntity<List<Reservation>> getAllReservation(){
        return new ResponseEntity<>(reservationService.getAllReservation(), HttpStatus.OK);
    }

    @GetMapping("/api/reservations/{id}")
    public ResponseEntity<Optional<Reservation>> getSingleReservation(@PathVariable ObjectId id){
        return new ResponseEntity<>(reservationService.getSingleReservation(id), HttpStatus.OK);
    }

    @PostMapping("/api/reservations/add")
    public void addAgence(@RequestBody Reservation reservation){
        reservationService.saveReservation(reservation);
    }


}
