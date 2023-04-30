package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.OwnerResponseDto;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Car;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.model.Owner;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OwnerResponseMapper implements ResponseMapper<Owner, OwnerResponseDto> {
    @Override
    public OwnerResponseDto toDto(Owner entity) {
        OwnerResponseDto dto = new OwnerResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        List<Long> carIds = entity.getCars().stream()
                .map(Car::getId)
                .collect(Collectors.toList());
        dto.setCarIds(carIds);

        List<Long> orderIds = entity.getOrders().stream()
                .map(Order::getId)
                .collect(Collectors.toList());
        dto.setOrderIds(orderIds);
        return dto;
    }
}
