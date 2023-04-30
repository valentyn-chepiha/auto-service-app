package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Order;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByIdIn(Set<Long> ids);
}
