package com.example.demo.services;

import com.example.demo.entities.Hoster;
import com.example.demo.repositories.HosterRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HosterService implements UserDetailsService {
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Hoster hoster = hosterRepository.findByEmail(email);
        if (hoster == null) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }

        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("HOSTER"));


        UserDetails userDetails = new Hoster(
                hoster.getId(),
                hoster.getName(),
                hoster.getAdresse(),
                hoster.getCni(),
                hoster.getPhone_number(),
                hoster.getRib(),
                hoster.getAge(),
                hoster.getCategory(),
                hoster.getUsername(),
                hoster.getPassword(),
                hoster.getEmail()
        );


        return userDetails;
    }
}
