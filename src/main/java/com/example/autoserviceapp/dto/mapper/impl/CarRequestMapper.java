package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.CarRequestDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.model.Owner;
import com.example.autoserviceapp.service.BaseService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CarRequestMapper implements RequestMapper<Car, CarRequestDto> {
    private BaseService<Owner, Long> ownerService;

    @Override
    public Car toModel(CarRequestDto dto) {
        Car car = new Car();
        car.setBrand(dto.getBrand());
        car.setCarNumber(dto.getCarNumber());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());

        Optional<Owner> optionalOwner = ownerService.get(dto.getOwnerId());
        car.setOwner(optionalOwner.get());
        return car;
    }
}
