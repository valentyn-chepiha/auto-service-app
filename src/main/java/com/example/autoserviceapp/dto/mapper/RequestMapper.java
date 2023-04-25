package com.example.autoserviceapp.dto.mapper;

public interface RequestMapper<E, D> {
    E toModel(D dto);
}
