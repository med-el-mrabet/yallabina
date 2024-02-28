package com.example.demo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "Listing")
@Data
public class Listing {
    @Id
    private BigInteger id;
    private String image;
    private String title;
    private String description;
    private String date;
    private Integer price;
    private String status;
    private String review;
    private String hoster_id;
    private String category;


    public Listing(){}


    public Listing(BigInteger id, String title, String description, String date, Integer price, String status, String review, String hoster_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.price = price;
        this.status = status;
        this.review = review;
        this.hoster_id = hoster_id;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate (String Date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice (Integer Price) {
        this.price = price;
    }

    public String getStatus(){ return status;}

    public void setStatus(String status){ this.status = status; }

    public String getReview(){ return review;}

    public void setReview(String review){ this.review = review; }

    public String getHoster_id(){ return hoster_id; }

    public void setHoster_id(String hoster_id){ this.hoster_id = hoster_id ;}
}
