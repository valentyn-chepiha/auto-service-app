package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.CarRequestDto;
import com.example.autoserviceapp.dto.CarResponseDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.service.BaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/car")
@AllArgsConstructor
public class CarController {
    private BaseService<Car, Long> carService;
    private RequestMapper<Car, CarRequestDto> carRequestMapper;
    private ResponseMapper<Car, CarResponseDto> carResponseDto;

    @PostMapping
    @ApiOperation(value = "Add new car to DB", notes = "Return new car with id")
    public CarResponseDto createCar(@RequestBody CarRequestDto carRequestDto) {
        Car car = carService.add(carRequestMapper.toModel(carRequestDto));
        return carResponseDto.toDto(car);
    }

    @PutMapping
    @ApiOperation(value = "Update info about car in DB", notes = "Return car from DB after update")
    public CarResponseDto updateCar(
            @RequestParam(name = "id") @ApiParam(name = "id", value = "Car id") Long id,
            @RequestBody CarRequestDto carRequestDto) {
        Car car = carRequestMapper.toModel(carRequestDto);
        car.setId(id);
        return carResponseDto.toDto(carService.update(car));
    }
}
