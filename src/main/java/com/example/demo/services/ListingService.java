package com.example.demo.services;

import com.example.demo.entities.Listing;
import com.example.demo.repositories.ListingRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingService {
    @Autowired
    private ListingRepository listingRepository;
    public List<Listing> getAllListing(){
        return listingRepository.findAll();
    }
    public Optional<Listing> getSingleListing(ObjectId id){
        return listingRepository.findById(id);
    }

    public void saveListing(Listing listing) {
        listingRepository.save(listing);
    }
}
