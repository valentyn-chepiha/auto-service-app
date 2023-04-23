package com.example.autoserviceapp.dto.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;
import com.example.autoserviceapp.dto.MasterResponseDto;
import com.example.autoserviceapp.dto.mapper.ResponseMapper;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.model.Operation;
import org.springframework.stereotype.Component;

@Component
public class MasterResponseMapper implements ResponseMapper<Master, MasterResponseDto> {
    @Override
    public MasterResponseDto toDto(Master entity) {
        MasterResponseDto dto = new MasterResponseDto();
        dto.setId(entity.getId());
        dto.setPib(entity.getPib());
        List<Long> repairIds = entity.getOperations().stream()
                .map(Operation::getId)
                .collect(Collectors.toList());
        dto.setRepairIds(repairIds);
        return dto;
    }
}
