package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.model.Operation;
import com.example.autoserviceapp.repository.MasterRepository;
import com.example.autoserviceapp.repository.OperationRepository;
import com.example.autoserviceapp.service.MasterService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MasterServiceImpl implements MasterService<Master, Long> {
    private static final BigDecimal SALARY_COEFFICIENT = BigDecimal.valueOf(0.4);

    private MasterRepository masterRepository;
    private OperationRepository operationRepository;

    @Override
    public Master add(Master entity) {
        return masterRepository.save(entity);
    }

    @Override
    public Master update(Master entity) {
        return masterRepository.save(entity);
    }

    @Override
    public Optional<Master> get(Long id) {
        return masterRepository.findById(id);
    }

    @Override
    public List<Master> getAll() {
        return masterRepository.findAll();
    }

    @Override
    public BigDecimal calculateSalary(Long id) {
        List<Operation> jobs = masterRepository.findById(id).get().getOperations();
        BigDecimal totalSum = jobs.stream()
                .filter(j -> Operation.StatusPaid.NOT_PAID.getName()
                        .equals(j.getStatus().getName()))
                .peek(j -> j.setStatus(Operation.StatusPaid.PAID))
                .peek(j -> operationRepository.save(j))
                .map(Operation::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalSum.multiply(SALARY_COEFFICIENT);
    }
}
