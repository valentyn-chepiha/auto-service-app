package com.example.autoserviceapp.repository;

import com.example.autoserviceapp.model.Detail;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
    List<Detail> findAllByIdIn(Set<Long> ids);
}
