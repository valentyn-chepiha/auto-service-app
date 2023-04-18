package com.example.autoserviceapp.service;

import java.util.List;
import java.util.Set;

public interface EntityRepairService<E, T> extends EntityService<E, T>{
    List<E> getAllByIds(Set<T> ids);
}
