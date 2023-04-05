package com.example.autoserviceapp.dto.mapper;

public interface ResponseMapper<E, D> {
    D toDto(E entity);
}
