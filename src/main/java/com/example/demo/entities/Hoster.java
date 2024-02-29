package com.example.demo.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.Collection;

@Document(collection = "Hoster")
@Data
@Getter
@Setter
public class Hoster implements UserDetails {
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
    private String email;

    public Hoster(){}

    public Hoster(BigInteger id, String name, String adresse, String cni, String phone_number, String rib, BigInteger age, String category, String username, String password, String email) {
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
