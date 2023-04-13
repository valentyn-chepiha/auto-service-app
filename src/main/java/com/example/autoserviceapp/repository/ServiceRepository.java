package com.example.autoserviceapp.repository;

import java.util.List;
import java.util.Set;
import com.example.autoserviceapp.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    public List<Service> findAllByIdIn(Set<Long> ids);
}
