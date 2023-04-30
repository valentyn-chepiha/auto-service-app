package com.example.autoserviceapp.service;

import java.util.List;
import java.util.Set;

public interface OperationService<E, T> extends BaseService<E, T> {
    List<E> getAllByIds(Set<T> ids);
}
