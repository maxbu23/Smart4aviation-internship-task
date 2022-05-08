package com.example.Smart4aviationinternshiptask.model.flight;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class FlightRequest {

    private Long flightNumber;
    private ZonedDateTime departureDate;
}
