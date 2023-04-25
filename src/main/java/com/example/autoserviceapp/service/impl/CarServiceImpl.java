package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.repository.CarRepository;
import com.example.autoserviceapp.service.EntityService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServiceImpl implements EntityService<Car, Long> {
    private CarRepository carRepository;

    @Override
    public Car add(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> get(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }
}
