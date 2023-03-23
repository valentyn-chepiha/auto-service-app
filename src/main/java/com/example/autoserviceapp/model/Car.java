package com.example.autoserviceapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cars")
public class Car {
    @Id
    private Long id;
    private String brand;
    private String model;
    private int year;
    @Column(name = "car_number")
    private String carNumber;
    @ManyToOne
    private Owner owner;
}
