package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.OperationResponseDto;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Operation;
import org.springframework.stereotype.Component;

@Component
public class OperationResponseMapper implements ResponseMapper<Operation, OperationResponseDto> {
    @Override
    public OperationResponseDto toDto(Operation entity) {
        OperationResponseDto dto = new OperationResponseDto();
        dto.setId(entity.getId());
        dto.setCost(entity.getCost());
        dto.setMasterId(entity.getMaster().getId());
        dto.setOrderId(entity.getOrder().getId());
        dto.setStatusName(entity.getStatus().getName());
        return dto;
    }
}
