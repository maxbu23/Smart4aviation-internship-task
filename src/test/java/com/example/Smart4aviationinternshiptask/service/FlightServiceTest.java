package com.example.Smart4aviationinternshiptask.service;

import com.example.Smart4aviationinternshiptask.model.cargo.Baggage;
import com.example.Smart4aviationinternshiptask.model.cargo.Cargo;
import com.example.Smart4aviationinternshiptask.model.cargo.CargoEntity;
import com.example.Smart4aviationinternshiptask.model.flight.Flight;
import com.example.Smart4aviationinternshiptask.model.flight.FlightResponse;
import com.example.Smart4aviationinternshiptask.repository.CargoEntityRepository;
import com.example.Smart4aviationinternshiptask.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

    @Mock private FlightRepository flightRepository;
    @Mock private CargoEntityRepository cargoEntityRepository;
    @InjectMocks private FlightService underTest;

    private Flight flight;
    private CargoEntity cargoEntity;

    @BeforeEach
    public void setUp(){
        flight = new Flight(
                0L,
                1055L,
                "YYZ",
                "LEW",
                ZonedDateTime.parse("2015-07-31T06:39:51-02:00")
        );
        List<Baggage> baggage = List.of(
                new Baggage(0L, 342, "kg", 344),
                new Baggage(1L, 76, "kg", 61),
                new Baggage(2L, 699, "lb", 372)
        );

        List<Cargo> cargos = List.of(
                new Cargo(0L, 235, "lb", 666),
                new Cargo(1L, 841, "lb", 994),
                new Cargo(2L, 345, "kg", 302)
        );
        cargoEntity = new CargoEntity(0L, baggage, cargos);
    }

    @Test
    public void givenFlightNumberAndDepartureDate_whenGetFlightResponse_thenReturnFlightResponse(){
        //given
        given(flightRepository
                .getByFlightNumberAndDepartureDate(1055L,ZonedDateTime.parse("2015-07-31T06:39:51-02:00")))
                .willReturn(Optional.of(flight));

        given(cargoEntityRepository
                .getById(flight.getFlightId()))
                .willReturn(cargoEntity);

        FlightResponse expectedFlightResponse = new FlightResponse(829.2,732.55,1561.75);

        //when
        final FlightResponse underTestFlightResponse = underTest.getFlightResponse(1055L, ZonedDateTime.parse("2015-07-31T06:39:51-02:00"));

        // then
        assertThat(expectedFlightResponse).isEqualTo(underTestFlightResponse);
    }

    @Test
    public void givenFlightNumberAndDepartureDateOfFlightThatIsNotPresentInDatabase_whenGetFlightResponse_thenReturnNoSuchElementException(){
        // given
        given(flightRepository.getByFlightNumberAndDepartureDate(1000L,ZonedDateTime.parse("2015-07-31T06:39:51-02:00")))
                .willReturn(Optional.empty());

        // when/then
        assertThrows(NoSuchElementException.class,()->underTest.getFlightResponse(1000L,ZonedDateTime.parse("2015-07-31T06:39:51-02:00")));

    }

}