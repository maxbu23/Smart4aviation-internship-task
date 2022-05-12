package com.example.Smart4aviationinternshiptask.service;

import com.example.Smart4aviationinternshiptask.model.airportInfo.AirportInfoResponse;
import com.example.Smart4aviationinternshiptask.model.cargo.Baggage;
import com.example.Smart4aviationinternshiptask.model.cargo.CargoEntity;
import com.example.Smart4aviationinternshiptask.model.flight.Flight;
import com.example.Smart4aviationinternshiptask.repository.CargoEntityRepository;
import com.example.Smart4aviationinternshiptask.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AirportService {

    private final FlightRepository flightRepository;
    private final CargoEntityRepository cargoEntityRepository;

    @Autowired
    public AirportService(FlightRepository flightRepository, CargoEntityRepository cargoEntityRepository) {
        this.flightRepository = flightRepository;
        this.cargoEntityRepository = cargoEntityRepository;
    }

    public AirportInfoResponse getAirportInfoResponse(String airportCode, ZonedDateTime departureDate){
        final List<Flight> arrivalFlights = flightRepository.getFlightsByArrivalAirportIATACodeAndDepartureDate(airportCode, departureDate)
                .orElseThrow(() -> new NoSuchElementException("Cannot find this flight"));

        final List<CargoEntity> arrivalCargoEntities = arrivalFlights.stream().map(Flight::getFlightId)
                .map(flightId -> cargoEntityRepository.getByFlightId(flightId).orElseThrow())
                .collect(Collectors.toList());

        final List<Flight> departureFlights = flightRepository.getFlightsByDepartureAirportIATACodeAndDepartureDate(airportCode, departureDate)
                .orElseThrow(() -> new NoSuchElementException("Cannot find this flight"));

        final List<CargoEntity> departureCargoEntities = departureFlights.stream().map(Flight::getFlightId)
                .map(flightId -> cargoEntityRepository.getByFlightId(flightId).orElseThrow())
                .collect(Collectors.toList());
        return new AirportInfoResponse(
                arrivalFlights.size(),
                departureFlights.size(),
                getNumberOfArrivalBaggagePieces(arrivalCargoEntities),
                getNumberOfDepartureBaggagePieces(departureCargoEntities)
        );
    }


    private Integer getNumberOfArrivalBaggagePieces(List<CargoEntity> arrivalCargoEntities){
        return arrivalCargoEntities.stream()
                .map(cargoEntity -> cargoEntity
                        .getBaggage()
                        .stream()
                        .map(Baggage::getPieces)
                        .reduce(0, Integer::sum))
                .reduce(0, Integer::sum);
    }

    private Integer getNumberOfDepartureBaggagePieces(List<CargoEntity> departureCargoEntities){
        return departureCargoEntities.stream()
                .map(cargoEntity -> cargoEntity
                        .getBaggage()
                        .stream()
                        .map(Baggage::getPieces)
                        .reduce(0, Integer::sum))
                .reduce(0, Integer::sum);
    }

}
