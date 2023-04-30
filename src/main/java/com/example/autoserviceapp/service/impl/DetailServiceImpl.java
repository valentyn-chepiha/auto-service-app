package com.example.autoserviceapp.service.impl;

import com.example.autoserviceapp.model.Detail;
import com.example.autoserviceapp.repository.DetailRepository;
import com.example.autoserviceapp.service.OperationService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements OperationService<Detail, Long> {
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

    @Override
    public List<Detail> getAllByIds(Set<Long> ids) {
        return detailRepository.findAllByIdIn(ids);
    }
}
