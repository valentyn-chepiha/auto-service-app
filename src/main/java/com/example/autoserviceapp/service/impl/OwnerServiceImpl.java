package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Owner;
import com.example.autoserviceapp.repository.OwnerRepository;
import com.example.autoserviceapp.service.EntityService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements EntityService<Owner, Long> {
    private OwnerRepository ownerRepository;

    @Override
    public Owner add(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner update(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Optional<Owner> get(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }
}
