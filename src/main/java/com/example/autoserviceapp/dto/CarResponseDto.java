package com.example.autoserviceapp.dto;

import lombok.Data;

@Data
public class CarResponseDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private String carNumber;
    private Long ownerId;
}
