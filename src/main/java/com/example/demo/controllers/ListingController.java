package com.example.demo.controllers;

import com.example.demo.entities.Listing;
import com.example.demo.services.ListingService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ListingController {
    @Autowired
    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }


    @GetMapping("/api/listings")
    public ResponseEntity<List<Listing>> getAllListing(){
        return new ResponseEntity<>(listingService.getAllListing(), HttpStatus.OK);
    }

    @GetMapping("/api/listings/{id}")
    public ResponseEntity<Optional<Listing>> getSingleListing(@PathVariable ObjectId id){
        return new ResponseEntity<>(listingService.getSingleListing(id), HttpStatus.OK);
    }

    @PostMapping("/api/listings/add")
    public void addAgence(@RequestBody Listing listing){
        listingService.saveListing(listing);
    }

}
