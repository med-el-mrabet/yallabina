package com.example.demo.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "Reservation")
@Data
@Getter
@Setter
public class Reservation {
    @Id
    private BigInteger id;
    private String status;
    private String bookingDate;
    private String hoster_id;
    private String visitor_id;
    private String listing_id;



    public Reservation(){}


    public Reservation(BigInteger id, String status, String bookingDate, String hoster_id, String visitor_id, String listing_id) {
        this.id = id;
        this.status = status;
        this.bookingDate = bookingDate;
        this.hoster_id = hoster_id;
        this.visitor_id = visitor_id;
        this.listing_id = listing_id;
    }



}
