package com.example.Smart4aviationinternshiptask.controller;

import com.example.Smart4aviationinternshiptask.model.airportInfo.AirportInfoRequest;
import com.example.Smart4aviationinternshiptask.model.airportInfo.AirportInfoResponse;
import com.example.Smart4aviationinternshiptask.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping(path = "/airports")
    public ResponseEntity<AirportInfoResponse> getAirportInfo(@RequestBody AirportInfoRequest airportInfoRequest){
        return new ResponseEntity<>(
                this.airportService.getAirportInfoResponse(airportInfoRequest.getAirportCode(),airportInfoRequest.getDepartureDate()),
                HttpStatus.ACCEPTED
        );
    }
}
