package com.example.Smart4aviationinternshiptask.model.flight;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightResponse {

    private Double cargoWeight;
    private Double baggageWeight;
    private Double totalWeight;
}
