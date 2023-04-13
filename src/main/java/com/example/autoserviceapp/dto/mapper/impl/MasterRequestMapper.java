package com.example.autoserviceapp.dto.mapper.impl;

import java.util.HashSet;
import java.util.Set;
import com.example.autoserviceapp.dto.MasterRequestDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.model.Master;
import org.springframework.stereotype.Component;

@Component
public class MasterRequestMapper implements RequestMapper<Master, MasterRequestDto> {
    @Override
    public Master toEntity(MasterRequestDto dto) {
        Master master = new Master();
        master.setPib(dto.getPib());
        Set<Long> serviceIds = new HashSet<>(dto.getServiceIds());
        return master;
    }
}
