package com.example.autoserviceapp.dto.mapper;

public interface RequestMapper<E, D> {
    E toEntity(D dto);
}
