package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.OrderResponseDto;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Detail;
import com.example.autoserviceapp.model.Operation;
import com.example.autoserviceapp.model.Order;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements ResponseMapper<Order, OrderResponseDto> {
    @Override
    public OrderResponseDto toDto(Order entity) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(entity.getId());
        dto.setCarId(entity.getCar().getId());
        dto.setDescription(entity.getDescription());
        dto.setDateStart(entity.getDateStart());
        dto.setOperationIds(entity.getOperations().stream()
                .map(Operation::getId)
                .collect(Collectors.toList()));
        dto.setDetailIds(entity.getDetails().stream()
                .map(Detail::getId)
                .collect(Collectors.toList()));
        dto.setStatusName(entity.getStatus().getName());
        dto.setTotal(entity.getTotal());
        dto.setDateEnd(entity.getDateEnd());
        dto.setOwnerId(entity.getOwner().getId());
        return dto;
    }
}
