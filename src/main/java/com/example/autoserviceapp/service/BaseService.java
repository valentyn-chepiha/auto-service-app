package com.example.autoserviceapp.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<E, T> {
    E add(E entity);

    E update(E entity);

    Optional<E> get(T id);

    List<E> getAll();
}
