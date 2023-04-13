package com.example.autoserviceapp.service.impl;

import java.util.List;
import java.util.Optional;
import com.example.autoserviceapp.model.Repair;
import com.example.autoserviceapp.repository.RepairRepository;
import com.example.autoserviceapp.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RepairServiceImpl implements EntityService<Repair, Long> {

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
}
