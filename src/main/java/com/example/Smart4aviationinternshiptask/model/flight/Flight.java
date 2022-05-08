package com.example.Smart4aviationinternshiptask.model.flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
@Data //for Hibernate
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    private Long flightId;
    private Long flightNumber;
    private String departureAirportIATACode;
    private String arrivalAirportIATACode;
    private ZonedDateTime departureDate;

}
