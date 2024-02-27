package com.example.demo;

import com.example.demo.entities.Hoster;
import com.example.demo.repositories.HosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class hosterservicelmpl implements hosterservice{
    @Autowired
    private HosterRepository hosterRepository;

    public hosterservicelmpl(HosterRepository hosterRepository) {
        this.hosterRepository = hosterRepository;
    }

    public List<Hoster> getAllHosters(){
        return hosterRepository.findAll();
    }
}