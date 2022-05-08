package com.example.Smart4aviationinternshiptask.model.airportInfo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AirportInfoResponse {
    private Integer numberOfFlightsArriving;
    private Integer numberOfFlightsDeparting;
    private Integer piecesOfBaggageArriving;
    private Integer piecesOfBaggageDeparting;

}
