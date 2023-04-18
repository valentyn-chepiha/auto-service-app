package com.example.autoserviceapp.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.model.Repair;
import com.example.autoserviceapp.repository.MasterRepository;
import com.example.autoserviceapp.repository.RepairRepository;
import com.example.autoserviceapp.service.EntityMasterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MasterServiceImpl implements EntityMasterService<Master, Long> {
    private static final BigDecimal SALARY_COEFFICIENT = BigDecimal.valueOf(0.4);

    private MasterRepository masterRepository;
    private RepairRepository repairRepository;

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
        List<Repair> jobs = masterRepository.findById(id).get().getRepairs();
        BigDecimal totalSum = jobs.stream()
                .filter(j -> Repair.StatusPaid.NOT_PAID.getName().equals(j.getStatus().getName()))
                .peek(j -> j.setStatus(Repair.StatusPaid.PAID))
                .peek(j -> repairRepository.save(j))
                .map(Repair::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalSum.multiply(SALARY_COEFFICIENT);
    }
}
