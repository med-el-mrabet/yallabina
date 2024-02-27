package com.example.demo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "Visitor")
@Data
public class Visitor {

    @Id
    private BigInteger id;
    private String name;
    private String adresse;
    private String cni;
    private String phone_number;
    private String rib;
    private BigInteger age;
    private String category;
    private String username;
    private String password;
    private String nationality;
    private String gender;
    private String email;

    public Visitor(){}

    public Visitor(BigInteger id, String name, String adresse, String cni, String phone_number, String rib, BigInteger age, String category, String username, String password, String nationality, String gender, String email) {
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
        this.nationality = nationality;
        this.gender = gender;
        this.email = email;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public BigInteger getAge() {
        return age;
    }

    public void setAge(BigInteger age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality(){ return nationality;}

    public void setNationality(){ this.nationality =  nationality;}

    public String getGender(){ return gender;}

    public void setGender(){ this.gender = gender;}
}
