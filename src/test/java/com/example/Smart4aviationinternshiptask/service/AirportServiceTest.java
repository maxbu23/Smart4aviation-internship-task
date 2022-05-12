package com.example.Smart4aviationinternshiptask.service;

import com.example.Smart4aviationinternshiptask.model.airportInfo.AirportInfoResponse;
import com.example.Smart4aviationinternshiptask.model.cargo.Baggage;
import com.example.Smart4aviationinternshiptask.model.cargo.Cargo;
import com.example.Smart4aviationinternshiptask.model.cargo.CargoEntity;
import com.example.Smart4aviationinternshiptask.model.flight.Flight;
import com.example.Smart4aviationinternshiptask.repository.CargoEntityRepository;
import com.example.Smart4aviationinternshiptask.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class AirportServiceTest {

    @Mock
    private FlightRepository flightRepository;
    @Mock
    private CargoEntityRepository cargoEntityRepository;
    @InjectMocks
    private AirportService underTest;

    private Flight firstFlight;
    private CargoEntity firstCargoEntity;

    @BeforeEach
    public void setUp(){

        firstFlight =new Flight(
                1L,
                1234L,
                "ABC",
                "XYZ",
                ZonedDateTime.parse("2015-07-31T06:39:51-02:00")

        );

        List<Baggage> baggage = List.of(
                new Baggage(1L, 100, "kg", 600),
                new Baggage(2L, 60, "lb", 200)
        );

        List<Cargo> cargos = List.of(
                new Cargo(1L, 200, "lb", 600),
                new Cargo(2L, 666, "kg", 150)
        );

        firstCargoEntity = new CargoEntity(1L,baggage,cargos);
    }
    
    @Test
    public void givenFlightAirportCodeAAndDepartureDate_whenGetAirportInfoResponse_returnAirportInfoResponse(){
        // given
        AirportInfoResponse expected = new AirportInfoResponse(
                1,
                1,
                800,
                800
        );
        String airportIATACode = "ABC";
        ZonedDateTime date =ZonedDateTime.parse("2015-07-31T06:39:51-02:00");

        when(flightRepository
                .getFlightsByArrivalAirportIATACodeAndDepartureDate(anyString(),any()))
                .thenReturn(Optional.of(Collections.singletonList(firstFlight)));
        when(cargoEntityRepository.getByFlightId(firstFlight.getFlightId()))
                .thenReturn(Optional.ofNullable(firstCargoEntity));
        when(flightRepository
                .getFlightsByDepartureAirportIATACodeAndDepartureDate(anyString(),any()))
                .thenReturn(Optional.of(Collections.singletonList(firstFlight)));
        when(cargoEntityRepository.getByFlightId(firstFlight.getFlightId()))
                .thenReturn(Optional.ofNullable(firstCargoEntity));

        // when
        final AirportInfoResponse airportInfoResponse = underTest.getAirportInfoResponse(airportIATACode, date);

        // then
        assertEquals(expected,airportInfoResponse);
    }


}
