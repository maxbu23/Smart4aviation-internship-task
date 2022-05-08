package com.example.Smart4aviationinternshiptask.repository;

import com.example.Smart4aviationinternshiptask.model.cargo.Baggage;
import com.example.Smart4aviationinternshiptask.model.cargo.Cargo;
import com.example.Smart4aviationinternshiptask.model.cargo.CargoEntity;
import com.example.Smart4aviationinternshiptask.model.flight.Flight;
import com.example.Smart4aviationinternshiptask.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class FlightRepositoryTest{

    @Autowired
    private FlightRepository underTest;

    @Test
    void isShouldGetByFlightNumberAndDepartureDate(){
        // given
        Flight flight = new Flight(
                0L,
                1055L,
                "YYZ",
                "LEW",
                ZonedDateTime.parse("2015-07-31T06:39:51-02:00")
        );
        underTest.save(flight);

        // when
        final Flight expected = underTest.getByFlightNumberAndDepartureDate(1055L,ZonedDateTime.parse("2015-07-31T06:39:51-02:00")).orElseThrow(
                () -> new NoSuchElementException("cannot find this element")
        );
        // then
        assertThat(expected).isEqualTo(flight);
    }
}
