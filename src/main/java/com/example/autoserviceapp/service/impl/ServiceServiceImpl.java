package com.example.autoserviceapp.service.impl;

import java.util.List;
import java.util.Optional;
import com.example.autoserviceapp.model.Service;
import com.example.autoserviceapp.repository.ServiceRepository;
import com.example.autoserviceapp.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ServiceServiceImpl implements EntityService<Service, Long> {

    private ServiceRepository serviceRepository;

    @Override
    public Service add(Service entity) {
        return serviceRepository.save(entity);
    }

    @Override
    public Service update(Service entity) {
        return serviceRepository.save(entity);
    }

    @Override
    public Optional<Service> get(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<Service> getAll() {
        return serviceRepository.findAll();
    }
}
