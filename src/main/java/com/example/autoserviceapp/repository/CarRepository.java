package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Car;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByIdIn(Set<Long> ids);
}
