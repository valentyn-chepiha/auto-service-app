package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.CarResponseDto;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarResponseMapper implements ResponseMapper<Car, CarResponseDto> {
    @Override
    public CarResponseDto toDto(Car entity) {
        CarResponseDto dto = new CarResponseDto();
        dto.setBrand(entity.getBrand());
        dto.setCarNumber(entity.getCarNumber());
        dto.setModel(entity.getModel());
        dto.setYear(entity.getYear());
        dto.setOwnerId(entity.getOwner().getId());
        return dto;
    }
}
