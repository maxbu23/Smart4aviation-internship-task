package com.example.Smart4aviationinternshiptask.model.cargo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoEntity {

    @Id
    private Long flightId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Baggage> baggage;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cargo> cargo;
}
