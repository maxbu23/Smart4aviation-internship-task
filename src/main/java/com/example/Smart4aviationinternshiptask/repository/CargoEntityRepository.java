package com.example.Smart4aviationinternshiptask.repository;

import com.example.Smart4aviationinternshiptask.model.cargo.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CargoEntityRepository extends JpaRepository<CargoEntity,Long> {

    Optional<CargoEntity> getByFlightId(Long flightId);
}
