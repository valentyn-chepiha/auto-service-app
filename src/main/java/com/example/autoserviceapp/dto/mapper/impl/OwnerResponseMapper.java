package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.OwnerResponseDto;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerResponseMapper implements ResponseMapper<Owner, OwnerResponseDto> {
    @Override
    public OwnerResponseDto toDto(Owner entity) {
        OwnerResponseDto dto = new OwnerResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCars(entity.getCars());
        dto.setOrders(entity.getOrders());
        return dto;
    }
}
