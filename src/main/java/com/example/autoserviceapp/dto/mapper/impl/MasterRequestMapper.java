package com.example.autoserviceapp.dto.mapper.impl;

import java.util.HashSet;
import java.util.Set;
import com.example.autoserviceapp.dto.MasterRequestDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.repository.RepairRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MasterRequestMapper implements RequestMapper<Master, MasterRequestDto> {

    private RepairRepository repairRepository;

    @Override
    public Master toEntity(MasterRequestDto dto) {
        Master master = new Master();
        master.setPib(dto.getPib());
        Set<Long> repairIds = new HashSet<>(dto.getRepairIds());
        master.setRepairs(repairRepository.findAllByIdIn(repairIds));
        return master;
    }
}