package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.OwnerRequestDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.model.Owner;
import com.example.autoserviceapp.repository.CarRepository;
import com.example.autoserviceapp.repository.OrderRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OwnerRequestMapper implements RequestMapper<Owner, OwnerRequestDto> {
    private CarRepository carRepository;
    private OrderRepository orderRepository;

    @Override
    public Owner toModel(OwnerRequestDto dto) {
        Owner entity = new Owner();
        entity.setName(dto.getName());

        Set<Long> carIds = new HashSet<>(dto.getCarIds());
        if (carIds.size() > 0) {
            entity.setCars(carRepository.findAllByIdIn(carIds));
        } else {
            entity.setCars(new ArrayList<>());
        }

        Set<Long> orderIds = new HashSet<>(dto.getOrderIds());
        if (orderIds.size() > 0) {
            entity.setOrders(orderRepository.findAllByIdIn(orderIds));
        } else {
            entity.setOrders(new ArrayList<>());
        }
        return entity;
    }
}
