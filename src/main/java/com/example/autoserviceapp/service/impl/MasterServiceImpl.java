package com.example.autoserviceapp.service.impl;

import java.util.List;
import java.util.Optional;
import com.example.autoserviceapp.model.Master;
import com.example.autoserviceapp.repository.MasterRepository;
import com.example.autoserviceapp.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MasterServiceImpl implements EntityService<Master, Long> {

    private MasterRepository masterRepository;

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
}
