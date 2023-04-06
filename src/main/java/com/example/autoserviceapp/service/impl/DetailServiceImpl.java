package com.example.autoserviceapp.service.impl;

import java.util.List;
import java.util.Optional;
import com.example.autoserviceapp.model.Detail;
import com.example.autoserviceapp.repository.DetailRepository;
import com.example.autoserviceapp.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DetailServiceImpl implements EntityService<Detail, Long> {
    private DetailRepository detailRepository;

    @Override
    public Detail add(Detail entity) {
        return detailRepository.save(entity);
    }

    @Override
    public Detail update(Detail entity) {
        return detailRepository.save(entity);
    }

    @Override
    public Optional<Detail> get(Long id) {
        return detailRepository.findById(id);
    }

    @Override
    public List<Detail> getAll() {
        return detailRepository.findAll();
    }
}
