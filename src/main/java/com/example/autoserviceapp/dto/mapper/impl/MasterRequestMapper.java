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
    private OperationRepository operationRepository;

    @Override
    public Master toModel(MasterRequestDto dto) {
        Master master = new Master();
        master.setPib(dto.getPib());
        Set<Long> operationIds = new HashSet<>(dto.getOperationIds());
        master.setOperations(operationRepository.findAllByIdIn(operationIds));
        return master;
    }
}
