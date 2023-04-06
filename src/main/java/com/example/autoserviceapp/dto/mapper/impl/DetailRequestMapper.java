package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.DetailRequestDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.model.Detail;
import org.springframework.stereotype.Component;

@Component
public class DetailRequestMapper implements RequestMapper<Detail, DetailRequestDto> {
    @Override
    public Detail toEntity(DetailRequestDto dto) {
        Detail detail = new Detail();
        detail.setName(dto.getName());
        detail.setPrice(dto.getPrice());
        return detail;
    }
}
