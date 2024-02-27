package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HosterResponseDTO {
    private String id;
    private String name;
    private String adresse;
    private String cni;
    private String phone_number;
    private String rib;
    private BigInteger age;
    private String category;
    private String username;
    private String password;
    private String email;

    public HosterResponseDTO(String id, String name, String adresse, String cni, String phone_number, String rib, BigInteger age, String category, String username, String password, String email) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.cni = cni;
        this.phone_number = phone_number;
        this.rib = rib;
        this.age = age;
        this.category = category;
        this.username = username;
        this.password = password;
        this.email = email;
    }

}
