package com.example.demo.services;

import com.example.demo.entities.Hoster;
import com.example.demo.repositories.HosterRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class HosterService {
    @Autowired
    private HosterRepository hosterRepository;
    public List<Hoster> getAllHosters(){
        return hosterRepository.findAll();
    }
    public Hoster getSingleHoster(ObjectId id){
        return hosterRepository.findById(id).orElse(null);
    }

    public void saveHoster(Hoster hoster) {
        hosterRepository.save(hoster);
    }


    public void deleteHoster(ObjectId id) {
        hosterRepository.deleteById(id);
    }

}
