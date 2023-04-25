package com.example.autoserviceapp.dto.mapper.impl;

import com.example.autoserviceapp.dto.MasterRequestDto;
import com.example.autoserviceapp.dto.mapper.RequestMapper;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.repository.OperationRepository;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MasterRequestMapper implements RequestMapper<Master, MasterRequestDto> {
    private OperationRepository repairRepository;

    @Override
    public Master toModel(MasterRequestDto dto) {
        Master master = new Master();
        master.setPib(dto.getPib());
        Set<Long> repairIds = new HashSet<>(dto.getRepairIds());
        master.setOperations(repairRepository.findAllByIdIn(repairIds));
        return master;
    }
}
