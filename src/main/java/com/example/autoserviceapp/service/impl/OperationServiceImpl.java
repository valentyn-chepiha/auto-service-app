package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Operation;
import com.example.autoserviceapp.repository.OperationRepository;
import com.example.autoserviceapp.service.OperationService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService<Operation, Long> {
    private OperationRepository operationRepository;

    @Override
    public Operation add(Operation entity) {
        return operationRepository.save(entity);
    }

    @Override
    public Operation update(Operation entity) {
        return operationRepository.save(entity);
    }

    @Override
    public Optional<Operation> get(Long id) {
        return operationRepository.findById(id);
    }

    @Override
    public List<Operation> getAll() {
        return operationRepository.findAll();
    }

    @Override
    public List<Operation> getAllByIds(Set<Long> ids) {
        return operationRepository.findAllByIdIn(ids);
    }

}
