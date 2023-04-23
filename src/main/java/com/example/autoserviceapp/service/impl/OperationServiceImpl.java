package com.example.autoserviceapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.example.autoserviceapp.model.Operation;
import com.example.autoserviceapp.repository.OperationRepository;
import com.example.autoserviceapp.service.EntityRepairService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OperationServiceImpl implements EntityRepairService<Operation, Long> {

    private OperationRepository repairRepository;

    @Override
    public Operation add(Operation entity) {
        return repairRepository.save(entity);
    }

    @Override
    public Operation update(Operation entity) {
        return repairRepository.save(entity);
    }

    @Override
    public Optional<Operation> get(Long id) {
        return repairRepository.findById(id);
    }

    @Override
    public List<Operation> getAll() {
        return repairRepository.findAll();
    }


    @Override
    public List<Operation> getAllByIds(Set<Long> ids) {
        return repairRepository.findAllByIdIn(ids);
    }

}
