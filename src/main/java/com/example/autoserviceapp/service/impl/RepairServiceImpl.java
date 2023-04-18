package com.example.autoserviceapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.example.autoserviceapp.model.Repair;
import com.example.autoserviceapp.repository.RepairRepository;
import com.example.autoserviceapp.service.EntityRepairService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RepairServiceImpl implements EntityRepairService<Repair, Long> {

    private RepairRepository repairRepository;

    @Override
    public Repair add(Repair entity) {
        return repairRepository.save(entity);
    }

    @Override
    public Repair update(Repair entity) {
        return repairRepository.save(entity);
    }

    @Override
    public Optional<Repair> get(Long id) {
        return repairRepository.findById(id);
    }

    @Override
    public List<Repair> getAll() {
        return repairRepository.findAll();
    }


    @Override
    public List<Repair> getAllByIds(Set<Long> ids) {
        return repairRepository.findAllByIdIn(ids);
    }

}
