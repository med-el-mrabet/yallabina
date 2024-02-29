package com.example.demo.controllers;

import com.example.demo.entities.Hoster;
import com.example.demo.hosterservice;
import com.example.demo.jwtconfigtocken.JwtUtil;
import com.example.demo.services.HosterService;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


@RestController
@PreAuthorize("hasRole('HOSTER')")
public class HosterController {
    @Autowired
    private final HosterService hosterService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    public HosterController(HosterService hosterService) {
        this.hosterService = hosterService;
    }


    @GetMapping("/api/hosters")
    public ResponseEntity<List<Hoster>> getAllHosters(){
        return new ResponseEntity<>(hosterService.getAllHosters(), HttpStatus.OK);
    }

    @GetMapping("/api/hosters/{id}")
    public ResponseEntity<Hoster> getSingleHoster(@PathVariable ObjectId id){
        return new ResponseEntity<>(hosterService.getSingleHoster(id), HttpStatus.OK);
    }

    @PostMapping("/api/hosters/add")
    public void addAgence(@RequestBody Hoster hoster){
        hosterService.saveHoster(hoster);
    }

    @DeleteMapping("/api/hosters/delete/{id}")
    public void deleteHoster(@PathVariable ObjectId id) {
        hosterService.deleteHoster(id);
    }
    @PutMapping("/api/hosters/update/{id}")
    public ResponseEntity<String> updateHoster(@PathVariable ObjectId id, @RequestBody Hoster updateHoster) {
        Hoster existingHoster = hosterService.getSingleHoster(id);

        if (existingHoster != null) {
            if (updateHoster.getName() != null) {
                existingHoster.setName(updateHoster.getName());
            }

            if (updateHoster.getAdresse() != null) {
                existingHoster.setAdresse(updateHoster.getAdresse());
            }

            if (updateHoster.getCni() != null) {
                existingHoster.setCni(updateHoster.getCni());
            }

            if (updateHoster.getPhone_number() != null) {
                existingHoster.setPhone_number(updateHoster.getPhone_number());
            }

            if (updateHoster.getRib() != null) {
                existingHoster.setRib(updateHoster.getRib());
            }
            if (updateHoster.getAge() != null) {
                existingHoster.setAge(updateHoster.getAge());
            }
            if (updateHoster.getCategory() != null) {
                existingHoster.setCategory(updateHoster.getCategory());
            }
            if (updateHoster.getUsername() != null) {
                existingHoster.setUsername(updateHoster.getUsername());
            }
            if (updateHoster.getPassword() != null) {
                existingHoster.setPassword(updateHoster.getPassword());
            }
            if (updateHoster.getEmail() != null) {
                existingHoster.setEmail(updateHoster.getEmail());
            }

            hosterService.saveHoster(existingHoster);

            String successMessage = "Hoster updated successfully";
            return ResponseEntity.ok().body("{\"message\":\""+successMessage+"\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> signIn(@RequestBody Hoster hoster) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(hoster.getEmail(), hoster.getPassword())
            );

            UserDetails userDetails = hosterService.loadUserByUsername(hoster.getEmail());

            if (!(hoster.isEnabled())) {
                // User account is not validated
                String errorMessage = "Veuillez activer votre compte en vérifiant votre e-mail.";
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JwtResponse(errorMessage, null, "", ""));
            }

            String jwt = jwtUtil.generateToken(userDetails);
            String role = "HOSTER";
            String username = userDetails.getUsername();
            String userId = String.valueOf((hoster.getId()));

            String prenom = hoster.getName();
            String nom = hoster.getName();
            String image = null;

            JwtResponse response = new JwtResponse(jwt, userId, username, role);
            response.setPrenom(prenom);
            response.setNom(nom);
            response.setImage(image);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            String errorMessage = "Invalid email or password";
            return ResponseEntity.badRequest().body(new JwtResponse(errorMessage, null, "", ""));
        }
    }




}
