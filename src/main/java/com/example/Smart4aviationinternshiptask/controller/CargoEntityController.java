package com.example.Smart4aviationinternshiptask.controller;

import com.example.Smart4aviationinternshiptask.model.cargo.CargoEntity;
import com.example.Smart4aviationinternshiptask.service.CargoEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CargoEntityController {

    private final CargoEntityService cargoEntityService;

    @Autowired
    public CargoEntityController(CargoEntityService cargoEntityService) {
        this.cargoEntityService = cargoEntityService;
    }

    @PostMapping("/cargos")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveCargoEntities(@RequestBody List<CargoEntity> cargoEntityList){
        this.cargoEntityService.saveCargoEntityList(cargoEntityList);
    }
}
