package com.example.Smart4aviationinternshiptask.repository;

import com.example.Smart4aviationinternshiptask.model.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {

    Optional<Flight> getByFlightNumberAndDepartureDate(Long flightNumber, ZonedDateTime departureDate);
    Optional<List<Flight>> getFlightsByArrivalAirportIATACodeAndDepartureDate (String airportCode, ZonedDateTime departureDate);
    Optional<List<Flight>> getFlightsByDepartureAirportIATACodeAndDepartureDate (String airportCode,ZonedDateTime departureDate);

}
