package com.example.autoserviceapp.dto;

import lombok.Data;

@Data
public class CarRequestDto {
    private String brand;
    private String model;
    private int year;
    private String carNumber;
    private long ownerId;
}