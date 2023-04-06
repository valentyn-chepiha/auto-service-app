package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.DetailResponseDto;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Detail;
import org.springframework.stereotype.Component;

@Component
public class DetailResponseMapper implements ResponseMapper<Detail, DetailResponseDto> {
    @Override
    public DetailResponseDto toDto(Detail detail) {
        DetailResponseDto dto = new DetailResponseDto();
        dto.setId(detail.getId());
        dto.setName(detail.getName());
        dto.setPrice(detail.getPrice());
        return dto;
    }
}
