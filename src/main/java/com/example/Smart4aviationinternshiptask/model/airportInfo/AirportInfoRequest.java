package com.example.Smart4aviationinternshiptask.model.airportInfo;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class AirportInfoRequest {

    private String airportCode;
    private ZonedDateTime departureDate;
}
