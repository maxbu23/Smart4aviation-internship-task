package com.example.Smart4aviationinternshiptask.model.cargo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Baggage {

    @Id
    @GeneratedValue
    private Long id;
    private Integer weight;
    private String weightUnit;
    private Integer pieces;
}
