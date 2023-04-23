package com.example.autoserviceapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.example.autoserviceapp.model.Order;
import com.example.autoserviceapp.repository.OrderRepository;
import com.example.autoserviceapp.service.EntityOperationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements EntityOperationService<Order, Long> {

    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllByIds(Set<Long> ids) {
        return orderRepository.findAllByIdIn(ids);
    }

    @Override
    public Order add(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Order update(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Optional<Order> get(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
