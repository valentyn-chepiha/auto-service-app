package com.example.autoserviceapp.repository;

import java.util.List;
import java.util.Set;
import com.example.autoserviceapp.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findAllByIdIn(Set<Long> ids);
}
