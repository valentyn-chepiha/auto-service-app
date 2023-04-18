package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.MasterResponseDto;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Master;
import org.springframework.stereotype.Component;

@Component
public class MasterResponseMapper implements ResponseMapper<Master, MasterResponseDto> {
    @Override
    public MasterResponseDto toDto(Master entity) {
        MasterResponseDto dto = new MasterResponseDto();
        dto.setId(entity.getId());
        dto.setPib(entity.getPib());
        dto.setRepairs(entity.getRepairs());
        return dto;
    }
}
