package com.example.Smart4aviationinternshiptask.service;

import com.example.Smart4aviationinternshiptask.model.airportInfo.AirportInfoResponse;
import com.example.Smart4aviationinternshiptask.model.cargo.CargoEntity;
import com.example.Smart4aviationinternshiptask.repository.CargoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoEntityService {

    private final CargoEntityRepository cargoEntityRepository;

    @Autowired
    public CargoEntityService(CargoEntityRepository cargoEntityRepository) {
        this.cargoEntityRepository = cargoEntityRepository;
    }

    public void saveCargoEntityList(List<CargoEntity> cargoEntityList){
        this.cargoEntityRepository.saveAll(cargoEntityList);
    }

}
