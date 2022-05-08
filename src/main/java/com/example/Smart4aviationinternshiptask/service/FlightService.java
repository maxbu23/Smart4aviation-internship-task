package com.example.Smart4aviationinternshiptask.service;

import com.example.Smart4aviationinternshiptask.model.cargo.CargoEntity;
import com.example.Smart4aviationinternshiptask.model.flight.Flight;
import com.example.Smart4aviationinternshiptask.model.flight.FlightResponse;
import com.example.Smart4aviationinternshiptask.repository.CargoEntityRepository;
import com.example.Smart4aviationinternshiptask.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final CargoEntityRepository cargoEntityRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, CargoEntityRepository cargoEntityRepository) {
        this.flightRepository = flightRepository;
        this.cargoEntityRepository = cargoEntityRepository;
    }

    public void saveFlightList(List<Flight> flightList){
        flightRepository.saveAll(flightList);
    }

    public FlightResponse getFlightResponse(Long flightNumber, ZonedDateTime departureDate){
        Flight flight = flightRepository.getByFlightNumberAndDepartureDate(flightNumber, departureDate).orElseThrow(
                () -> new NoSuchElementException("Cannot find flight with flightNumber: "+flightNumber)
        );
        final CargoEntity cargoEntity = cargoEntityRepository.getById(flight.getFlightId());
        return new FlightResponse(
                getCargoWeight(cargoEntity),
                getBaggageWeight(cargoEntity),
                getCargoWeight(cargoEntity) + getBaggageWeight(cargoEntity));
    }

    private Double getCargoWeight(CargoEntity cargoEntity){
        return cargoEntity.getCargo()
                .stream()
                .map(cargo -> cargo.getWeightUnit().equals("kg") ? cargo.getWeight() : cargo.getWeight() * 0.45)
                .reduce(0.0,Double::sum);
    }

    private Double getBaggageWeight(CargoEntity cargoEntity){
        return cargoEntity.getBaggage()
                .stream()
                .map(baggage -> baggage.getWeightUnit().equals("kg") ? baggage.getWeight() : baggage.getWeight() * 0.45)
                .reduce(0.0,Double::sum);
    }
}
