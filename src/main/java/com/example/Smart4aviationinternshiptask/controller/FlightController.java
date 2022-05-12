package com.example.Smart4aviationinternshiptask.controller;

import com.example.Smart4aviationinternshiptask.model.flight.Flight;
import com.example.Smart4aviationinternshiptask.model.flight.FlightRequest;
import com.example.Smart4aviationinternshiptask.model.flight.FlightResponse;
import com.example.Smart4aviationinternshiptask.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping(path = "/flights")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveFlightList(@RequestBody List<Flight> flightList){
        this.flightService.saveFlightList(flightList);
    }

    @GetMapping(path = "/flights")
    public ResponseEntity<FlightResponse> getFlightByFlightId(@RequestBody FlightRequest flightRequest){
        return new ResponseEntity<>(
                flightService.getFlightResponse(flightRequest.getFlightNumber(),flightRequest.getDepartureDate()),
                HttpStatus.ACCEPTED);
    }
}
