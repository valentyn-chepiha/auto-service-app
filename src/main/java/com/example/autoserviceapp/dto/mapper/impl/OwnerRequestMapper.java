package com.example.autoserviceapp.dto.mapper.impl;

import java.util.HashSet;
import java.util.Set;
import com.example.autoserviceapp.dto.OwnerRequestDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.model.Owner;
import com.example.autoserviceapp.repository.CarRepository;
import com.example.autoserviceapp.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OwnerRequestMapper implements RequestMapper<Owner, OwnerRequestDto> {

    private CarRepository carRepository;
    private OrderRepository orderRepository;

    @Override
    public Owner toEntity(OwnerRequestDto dto) {
        Owner entity = new Owner();
        entity.setName(dto.getName());

        Set<Long> carIds = new HashSet<>(dto.getCarIds());
        entity.setCars(carRepository.findAllByIdIn(carIds));

        Set<Long> orderIds = new HashSet<>(dto.getOrderIds());
        entity.setOrders(orderRepository.findAllByIdIn(orderIds));
        return entity;
    }
}