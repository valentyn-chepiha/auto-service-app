package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Operation;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findAllByIdIn(Set<Long> ids);
}
